package software.lawyer.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/nsfw")
public class HomeFrameController {
	@RequestMapping(value = "home_frame.do", method = RequestMethod.GET)
	public String frame(HttpServletRequest request, Model model,
			HttpServletResponse response) {
		return "/frame";
	}
	@RequestMapping(value = "home_top.do", method = RequestMethod.GET)
	public String top(HttpServletRequest request, Model model,
			HttpServletResponse response) {
		return "/top";
	}
	@RequestMapping(value = "home_left.do", method = RequestMethod.GET)
	public String left(HttpServletRequest request, Model model,
			HttpServletResponse response) {
		return "/left";
	}
	
}
