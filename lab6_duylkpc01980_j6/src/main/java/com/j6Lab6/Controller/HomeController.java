package com.j6Lab6.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/home/index")
	public String index(Model m) {
		m.addAttribute("message","This is home page");
		return "home/index";
	}
	
	@RequestMapping("/home/about")
	public String about(Model m) {
		m.addAttribute("message","This is introdution page");
		return "home/index";
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/home/admins")
	public String admins(Model m) {
		if(!request.isUserInRole("ADMIN")) {
			return "redirect:/auth/access/denied";
		}
		m.addAttribute("message","Hello administrator");
		return "home/index";
	}
	//@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@RequestMapping("/home/users")
	public String users(Model m) {
		if(!request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			return "redirect:/auth/access/denied";
		}
		m.addAttribute("message","Hello staff");
		return "home/index";
	}
	//@PreAuthorize("isAuthenticated()")
	@RequestMapping("/home/authenticated")
	public String autheniticated(Model m) {
		if(request.getRemoteUser() == null) {
			return "redirect:/auth/login/form";
		}
		m.addAttribute("message","Hello autheniticated user");
		return "home/index";
	}
	
	@RequestMapping("/home/thymeleaf1")
	public String thymeleaf1(Model m) {
		m.addAttribute("message","Thymeleaf - Without Extras");
		return "home/thymeleaf1";
	}
	
	@RequestMapping("/home/thymeleaf2")
	public String thymeleaf2(Model m) {
		m.addAttribute("message","Thymeleaf - With Extras");
		return "home/thymeleaf2";
	}
}
