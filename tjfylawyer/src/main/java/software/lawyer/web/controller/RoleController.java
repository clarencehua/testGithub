package software.lawyer.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import software.lawyer.data.dataobject.PageResult;
import software.lawyer.data.dataobject.Role;
import software.lawyer.data.dataobject.RolePrivilege;
import software.lawyer.data.dataobject.User;
import software.lawyer.dynamicds.Constant;
import software.lawyer.service.RoleService;
import software.lawyer.service.convertor.RoleConvertor;
import software.lawyer.service.model.RoleCustom;
import software.lawyer.service.model.RoleModel;
import software.lawyer.service.model.RolePrivilegeModel;
import software.lawyer.service.model.UserCustom;
import software.lawyer.util.QueryHelper;
import software.lawyer.util.StringUtil;
import software.lawyer.util.UUIDGenerator;

@Controller
@RequestMapping("/nsfw")
public class RoleController {
	@Resource
	private RoleService roleService;

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	// 列表页面
	@RequestMapping(value = "role_listUI.do", method ={ RequestMethod.GET,RequestMethod.POST})
	public String listUI(HttpServletRequest request, Model model,
			HttpServletResponse response,RoleCustom roleCustom) {
		PageResult pageResult=new PageResult();
		String pageNo=request.getParameter("pageNo");
		pageNo= (String) ((pageNo==null)?"1":pageNo);
		pageResult.setPageNo(Integer.parseInt(pageNo));
		
		Role role=roleCustom.getRole();
		QueryHelper queryHelper=new QueryHelper(Role.class, "i");
		if (role!=null) {
			if (!StringUtil.isBlank(role.getName())) {
				queryHelper.addCondition("i.name like ?", "%"+role.getName()+"%");
			}
		}
		//根据创建时间排序
		queryHelper.addOrderByProperty("i.id", QueryHelper.ORDER_BY_DESC);
		
		PageResult pageResult2 = roleService.getPageResult(queryHelper,pageResult.getPageNo(),3);
		request.setAttribute("pageResult", pageResult2);
		//List<Role> roleList = roleService.findObjects();

		RoleConvertor roleConvertor = new RoleConvertor();
		List<RoleModel> roleModels = roleConvertor.roleDescribe(pageResult2.getItems());
		model.addAttribute("roleList", roleModels);
		model.addAttribute("privilegeMap", Constant.PRIVILEGE_MAP);

		return "role/listUI";
	}

	// 跳转到新增页面
	@RequestMapping(value = "role_addUI.do", method = RequestMethod.POST)
	public String addUI(HttpServletRequest request, HttpServletResponse response) {

		return "role/addUI";
	}

	// 保存新增
	@RequestMapping(value = "role_add.do", method = RequestMethod.POST)
	public String add(HttpServletRequest request, HttpServletResponse response,
			RoleCustom roleCustom) {
		Set set = new HashSet<RolePrivilege>();
		String str[] = request.getParameterValues("privilegeIds");
		String id = UUIDGenerator.getUUID();
		for (String string : str) {
			RolePrivilege rolePrivilege = new RolePrivilege();
			rolePrivilege.setCode(string);
			rolePrivilege.setRole(roleCustom.getRole());
			rolePrivilege.setRoleId(id);
			set.add(rolePrivilege);
		}
		Role role = roleCustom.getRole();
		role.setRoleId(id);
		role.setRolePrivileges(set);

		roleService.save(role);
		return "redirect:role_listUI.do";
	}

	// 跳转到编辑页面
	@RequestMapping(value = "role_editUI.do", method = RequestMethod.POST)
	public String editUI(HttpServletRequest request,
			HttpServletResponse response, RoleCustom roleCustom, Model model) {
		Role role = roleCustom.getRole();
		if (role != null) {
			role = roleService.findObjectById(role.getRoleId());
		}
		model.addAttribute("role", role);
		return "role/editUI";
	}

	// 保存编辑user_edit.do
	@RequestMapping(value = "role_edit.do", method = RequestMethod.POST)
	public String edit(HttpServletRequest request,
			HttpServletResponse response, RoleCustom roleCustom, Model model) {
		Role role = roleCustom.getRole();
		Set set = new HashSet<RolePrivilege>();
		String str[] = request.getParameterValues("privilegeIds");
		for (String string : str) {
			RolePrivilege rolePrivilege = new RolePrivilege();
			rolePrivilege.setCode(string);
			rolePrivilege.setRole(roleCustom.getRole());
			rolePrivilege.setRoleId(role.getRoleId());
			set.add(rolePrivilege);
		}
		role.setRolePrivileges(set);
		roleService.update(role);
		return "redirect:role_listUI.do";
	}

	// 删除user_delete.do
	@RequestMapping(value = "role_delete.do", method = RequestMethod.POST)
	public String delete(HttpServletRequest request,
			HttpServletResponse response, RoleCustom roleCustom, Model model) {
		Role role = roleCustom.getRole();
		if (role != null && (role.getRoleId() != null)) {
			roleService.delete(role.getRoleId());
		}
		return "redirect:role_listUI.do";
	}

	// 批量删除user_deleteSelected.do
	@RequestMapping(value = "role_deleteSelected.do", method = RequestMethod.POST)
	public String deleteSelected(HttpServletRequest request,
			HttpServletResponse response, RoleCustom roleCustom, Model model) {
		String str[] = request.getParameter("id").split(",");
		for (String string : str) {
			roleService.delete(string);
		}
		return "redirect:role_listUI.do";
	}
}
