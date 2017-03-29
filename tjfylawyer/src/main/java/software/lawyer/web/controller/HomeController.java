package software.lawyer.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import software.lawyer.data.dataobject.Complain;
import software.lawyer.data.dataobject.User;
import software.lawyer.service.ComplainService;
import software.lawyer.service.UserService;
import software.lawyer.service.model.ComplainCustom;
import software.lawyer.util.DateUtil;
import software.lawyer.util.QueryHelper;
import software.lawyer.util.ResponseBuilder;
import software.lawyer.util.StringUtil;

@Controller
@RequestMapping("/sys")
public class HomeController {
	@Resource
	private UserService userService;
	private ComplainService complainService;
	
	public ComplainService getComplainService() {
		return complainService;
	}

	public void setComplainService(ComplainService complainService) {
		this.complainService = complainService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model,
			HttpServletResponse response) {
		return "/home/home";
	}

	// home_complainAddUI.do
	@RequestMapping(value = "home_complainAddUI.do", method = RequestMethod.GET)
	public String complainAddUI(HttpServletRequest request, Model model,
			HttpServletResponse response) {
		return "/home/complainAddUI";
	}

	// home_getUserJson.aj
	@RequestMapping(value = "home_getUserJson.aj", method = RequestMethod.POST)
	public void getUserJson(HttpServletRequest request, Model model,
			HttpServletResponse response) throws Exception {
		String dept = request.getParameter("dept");
		if (!StringUtil.isBlank(dept)) {
			QueryHelper queryHelper = new QueryHelper(User.class, "u");
			queryHelper.addCondition("u.dept like ?", "%" + dept);
			// 2、根据部门查询用户列表
			List<User> userList = userService.findObjects(queryHelper);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("msg", "success");
			map.put("userList", userService.findObjects(queryHelper));
			new ResponseBuilder().writeJsonResponse(response, map);
		}
	}

	// home_complainAdd.do
	@RequestMapping(value = "home_complainAdd.do", method = RequestMethod.POST)
	public void complainAdd(HttpServletRequest request, Model model,
			HttpServletResponse response, ComplainCustom complainCustom) {
		Complain comp = complainCustom.getComplain();
		if (comp != null) {
			//设置默写投诉状态为 待受理
			comp.setState(Complain.COMPLAIN_STATE_UNDONE);
			comp.setCompTime(DateUtil.format(new Date(), DateUtil.secondFormat));
			complainService.save(comp);	
			Map<String, String> map = new HashMap<String, String>();
			map.put("msg", "success");
			try {
				new ResponseBuilder().writeJsonResponse(response, map);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
