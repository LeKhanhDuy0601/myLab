package com.j6Lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.j6Lab3.bean.student2;

@Controller
public class validationController {
	@GetMapping("/validation/form")
	public String form(Model model) {
		student2 student = new student2();
		model.addAttribute("student", student);
		return "validation/form";
	}

	@PostMapping("/validation/validation")
	public String save(Model model, @Validated @ModelAttribute("student") student2 form, Errors erros) {
		if (erros.hasErrors()) {
			model.addAttribute("erro", "vui lòng kiểm tra lổi");
			System.err.println("Lổi");
			return "/validation/form";
		}
		return "/validation/success";
	}
}
