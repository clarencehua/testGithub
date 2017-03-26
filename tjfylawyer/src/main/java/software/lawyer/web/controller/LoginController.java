package software.lawyer.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import software.lawyer.data.dataobject.User;
import software.lawyer.data.dataobject.UserRole;
import software.lawyer.dynamicds.Constant;
import software.lawyer.service.UserService;
import software.lawyer.service.model.UserCustom;
import software.lawyer.service.model.UserModel;
import software.lawyer.util.StringUtil;

@Controller
@RequestMapping("/sys")
public class LoginController {
	@Resource 
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "login_toLoginUI.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String login(HttpServletRequest request, Model model,
			HttpServletResponse response,UserCustom userCustom) {
		User user1=userCustom.getUser();
		String loginResult=null;
		//userService.findUserByAccountAndPass(user.getAccount(), user.getPassword());
		if (user1!=null) {
			if (!StringUtil.isBlank(user1.getAccount())&&!StringUtil.isBlank(user1.getPassword())) {
				//根据用户的帐号和密码查询
				List<User> list=userService.findUserByAccountAndPass(user1.getAccount(), user1.getPassword());
				if (list!=null&&list.size()>0) {
					User user= list.get(0);
				//	user.setUserRoles(userService.getUserRolesByUserId(user.getId()+""));
					List<UserRole> userRoles=userService.getUserRolesByUserId(user.getId()+"");
					UserModel userModel=new UserModel(user.getId(), user.getDept(), user.getAccount(), user.getName(), user.getPassword(), user.getHeadImg(), user.isGender(), user.getState(), user.getMobile(), user.getEmail(), user.getBirthday(), user.getMemo(), userRoles);
					request.getSession().setAttribute(Constant.USER, userModel);
					return "/home/home";
				}else{
					loginResult = "帐号或密码不正确！";
				}
			}else{
				loginResult = "帐号或密码不能为空！";
			}
		}else {
			loginResult = "请输入帐号和密码！";
		}
		//request.getSession().invalidate();
		return "loginUI";
	}
	@RequestMapping(value = "login_logout.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String logout(HttpServletRequest request, Model model,
			HttpServletResponse response,UserCustom userCustom) {
		request.getSession().invalidate();	
		return "loginUI";
	}
	@RequestMapping(value = "login_toNoPermissionUI.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String toNoPermissionUI(HttpServletRequest request, Model model,
			HttpServletResponse response) {
		return "noPermissionUI";
	}
}
