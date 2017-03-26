package software.lawyer.web.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import software.lawyer.data.dataobject.Info;
import software.lawyer.data.dataobject.PageResult;
import software.lawyer.data.dataobject.Role;
import software.lawyer.data.dataobject.User;
import software.lawyer.data.dataobject.UserRole;
import software.lawyer.service.RoleService;
import software.lawyer.service.UserService;
import software.lawyer.service.model.UserCustom;
import software.lawyer.util.QueryHelper;
import software.lawyer.util.StringUtil;
import software.lawyer.web.ResponseBuilder;

@Controller
@RequestMapping("/nsfw")
public class UserController {
	@Resource
	private UserService userService;
	private RoleService roleService;
	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 列表页面
	@RequestMapping(value = "user_listUI.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String listUI(HttpServletRequest request,
			HttpServletResponse response,UserCustom userCustom) {
		PageResult pageResult=new PageResult();
		String pageNo=request.getParameter("pageNo");
		pageNo= (String) ((pageNo==null)?"1":pageNo);
		pageResult.setPageNo(Integer.parseInt(pageNo));
		
		User user=userCustom.getUser();
		QueryHelper queryHelper=new QueryHelper(User.class, "i");
		if (user!=null) {
			if (!StringUtil.isBlank(user.getName())) {
				queryHelper.addCondition("i.name like ?", "%"+user.getName()+"%");
			}
		}
		//根据创建时间排序
		queryHelper.addOrderByProperty("i.id", QueryHelper.ORDER_BY_DESC);
		
		PageResult pageResult2 = userService.getPageResult(queryHelper,pageResult.getPageNo(),3);
		request.setAttribute("pageResult", pageResult2);
		
		return "user/listUI";
	}

	// 跳转到新增页面
	@RequestMapping(value = "user_addUI.do", method = RequestMethod.POST)
	public String addUI(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("roleList", roleService.findObjects());
		return "user/addUI";
	}

	// 保存新增
	@RequestMapping(value = "user_add.do", method = RequestMethod.POST)
	public String add(HttpServletRequest request, HttpServletResponse response,
			UserCustom userCustom) {
		//userService.save(userCustom.getUser());
		String[] userRoleIds=request.getParameterValues("userRoleIds");
		userService.saveUserAndRole(userCustom.getUser(), userRoleIds);
		return "redirect:user_listUI.do";
	}

	// 跳转到编辑页面
	@RequestMapping(value = "user_editUI.do", method = RequestMethod.POST)
	public String editUI(HttpServletRequest request,
			HttpServletResponse response, UserCustom userCustom, Model model) {
		User user = userCustom.getUser();
		String[] userRoleIds=null;
		if (userCustom.getUser() != null
				&& (userCustom.getUser().getId() + "" != null || String
						.valueOf(userCustom.getUser().getId()).equals(" "))) {
			user = userService.findObjectById(userCustom.getUser().getId());
		}
		
		List<UserRole> list=userService.getUserRolesByUserId(user.getId()+"");
		if(list != null && list.size() > 0){
			userRoleIds=new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				userRoleIds[i]=list.get(i).getRoleId();
			}
		}
		model.addAttribute("user", user);
		model.addAttribute("roleList",roleService.findObjects());
		model.addAttribute("roleIds", userRoleIds);
		return "user/editUI";
	}

	// 保存编辑user_edit.do
	@RequestMapping(value = "user_edit.do", method = RequestMethod.POST)
	public String edit(HttpServletRequest request,
			HttpServletResponse response, UserCustom userCustom, Model model) {
		User user = userCustom.getUser();
		String[] userRoleIds=request.getParameterValues("userRoleIds");
		try {
			if (user != null) {
				// 处理头像
			}
			//userService.updateEdite(user);
			userService.updateUserAndRole(user, userRoleIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:user_listUI.do";
	}

	// 删除user_delete.do
	@RequestMapping(value = "user_delete.do", method = RequestMethod.POST)
	public String delete(HttpServletRequest request,
			HttpServletResponse response, UserCustom userCustom, Model model) {
		User user = userCustom.getUser();
		if (userCustom.getUser() != null
				&& (userCustom.getUser().getId() + "" != null || String
						.valueOf(userCustom.getUser().getId()).equals(" "))) {
			userService.delete(user.getId());
		}
		return "redirect:user_listUI.do";
	}

	// 批量删除user_deleteSelected.do
	@RequestMapping(value = "user_deleteSelected.do", method = RequestMethod.POST)
	public String deleteSelected(HttpServletRequest request,
			HttpServletResponse response, UserCustom userCustom, Model model) {
		String str[] = request.getParameter("id").split(",");
		for (String string : str) {
			userService.delete(Integer.parseInt(string));
		}
		return "redirect:user_listUI.do";
	}

	// user_exportExcel.do
	// 导出用户列表
	@RequestMapping(value = "user_exportExcel.do", method = RequestMethod.GET)
	public void exportExcel(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// 1、查找用户列表
			List<User> userList = userService.findObjects();
			// 2、导出
			response.setContentType("application/x-execl");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String("用户列表.xls".getBytes(), "ISO-8859-1"));
			ServletOutputStream outputStream = response.getOutputStream();
			userService.exportExcel(userList, outputStream);
			if (outputStream != null) {
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 导入用户列表user_importExcel.do
	@RequestMapping(value = "user_importExcel.do", method = RequestMethod.POST)
	public String importExcel(HttpServletRequest request,
			HttpServletResponse response) {
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile cm = (CommonsMultipartFile) multipartRequest.getFile("userExcel");
		//获取文件上传流
		byte[] fbytes = cm.getBytes();
		InputStream input = new ByteArrayInputStream(fbytes);
		String originalFilename=cm.getOriginalFilename();
		// 1、获取excel文件
		if (originalFilename != null) {
			// 是否是excel
			if (originalFilename.matches("^.+\\.(?i)((xls)|(xlsx))$")) {
				// 2、导入
				userService.importExcel(input, originalFilename);
			}
		}
		
		return "redirect:user_listUI.do";
	}
	//检查帐号的唯一性user_verifyAccount.do
	@RequestMapping(value = "user_verifyAccount.do", method = RequestMethod.POST)
	public void verifyAccount(HttpServletRequest request,
			HttpServletResponse response, UserCustom userCustom, Model model){
		try {
			User user=userCustom.getUser();
			//1、获取帐号
			if(user!= null && StringUtil.isNotBlank(user.getAccount())){
				//2、根据帐号到数据库中校验是否存在该帐号对应的用户
				List<User> list = userService.findUserByAccountAndId(user.getId()+"", user.getAccount());
				String strResult = "true";
				if(list != null && list.size() > 0){
					//说明该帐号已经存在
					strResult = "false";
				}
				Map map=new HashMap();
				map.put("key", strResult);
				new ResponseBuilder().writeJsonResponse(response, map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
