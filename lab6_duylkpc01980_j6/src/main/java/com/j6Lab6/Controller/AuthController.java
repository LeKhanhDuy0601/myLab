package com.j6Lab6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
	@RequestMapping("/auth/login/form")
	public String form() {
		return "auth/login";
	}

	@RequestMapping("/auth/login/error")
	public String error(Model m) {
		m.addAttribute("message", "sai thông tin đăng nhập");
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/login/success")
	public String success(Model m) {
		m.addAttribute("message", "Đăng nhập thành công");
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/logoff/success")
	public String logoff(Model m) {
		m.addAttribute("message", "Đăng xuất thành công");
		return "forward:/auth/login/form";
	}

	@RequestMapping("/auth/access/denied")
	public String denied(Model m) {
		m.addAttribute("message", "Bạn không có quyền truy xuất");
		return "auth/login";
	}
}
