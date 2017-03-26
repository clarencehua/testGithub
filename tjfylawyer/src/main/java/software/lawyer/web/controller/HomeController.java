package software.lawyer.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sys")
public class HomeController {
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model,
			HttpServletResponse response) {
		return "/home/home";
	}
}
