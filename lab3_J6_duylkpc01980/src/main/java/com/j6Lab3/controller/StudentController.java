package com.j6Lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.j6Lab3.bean.student;

@Controller
public class StudentController {
	@GetMapping("/student/form")
	public String form(Model model) {
		student student = new student();
		model.addAttribute("student", student);
		System.out.println("test");
		return "student/form";
	}

	@PostMapping("/student/save")
	public String save(@ModelAttribute("student") student form) {
		return "student/success";
	}
}
