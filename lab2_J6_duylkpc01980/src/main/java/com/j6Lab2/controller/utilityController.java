package com.j6Lab2.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6Lab2.bean.Student;

@Controller
public class utilityController {
	@RequestMapping("/demo/utilities")
	public String index(Model model) throws IOException {
		File path = new ClassPathResource("/static/students.json").getFile();
		ObjectMapper objMapper = new ObjectMapper();
		TypeReference<List<Student>> type = new TypeReference<List<Student>>() {
		};
		List<Student> list = objMapper.readValue(path, type);

		model.addAttribute("listStudent", list);
		model.addAttribute("now", new Date());
		return "utilities";
	}
}
