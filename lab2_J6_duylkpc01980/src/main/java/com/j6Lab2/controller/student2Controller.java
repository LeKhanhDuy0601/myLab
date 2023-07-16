package com.j6Lab2.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6Lab2.bean.Student;

@Controller
public class student2Controller {
	@RequestMapping("/student/list")
	public String index(Model model, @RequestParam("index") Optional<Integer> index) throws IOException {
		//ClassPathResource đọc file dể hơn
		File path = new ClassPathResource("/static/students.json").getFile();
		ObjectMapper objMapper = new ObjectMapper();
		TypeReference<List<Student>> type = new TypeReference<List<Student>>() {
		};
		List<Student> list = objMapper.readValue(path, type);
		System.err.println("Tổng: "+ list.size());
		model.addAttribute("size",list.size());
		model.addAttribute("student", list.get(index.orElse(0)));
		model.addAttribute("listStudent",list);
		return "student/list";
	}
}
