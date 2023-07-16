package com.j6Lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	@GetMapping("/home/index")
	String home(Model model) {
		return "home/index";
	}
	@GetMapping("/home/about")
	String about(Model model) {
		return "home/about";
	}
}
