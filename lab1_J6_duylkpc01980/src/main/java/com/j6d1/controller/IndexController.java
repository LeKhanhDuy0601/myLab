package com.j6d1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/json")
	public String json() {
		return "/json.html";
	}
}
