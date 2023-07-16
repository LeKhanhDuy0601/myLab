package com.j6Lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello.th")
	public String hello(Model model) {
		model.addAttribute("mess", "Hello FPT <b>POLYTECHNIC</b>");
		return "hello";
	}
}
