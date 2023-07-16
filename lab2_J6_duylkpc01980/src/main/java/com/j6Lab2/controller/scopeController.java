package com.j6Lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class scopeController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/scope")
	public String index(Model model) {
		model.addAttribute("a","Tôi đang ở trong Model");
		request.setAttribute("b", "Tôi đang ở trong Request Scope");
		session.setAttribute("c", "Tôi đang ở trong Session Scope");
		servletContext.setAttribute("d", "Tôi đang ở trong Application Scope");
		
		return "scope/index";
	}
}
