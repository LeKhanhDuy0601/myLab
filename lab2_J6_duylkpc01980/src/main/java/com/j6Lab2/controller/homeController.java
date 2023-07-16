package com.j6Lab2.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6Lab2.bean.Student;

@Controller
public class homeController {
	@RequestMapping("/home/index")
	public String home(Model model) throws StreamReadException, DatabindException, IOException {
		model.addAttribute("mess", "Hello FPT <b>POLYTECHNIC</b>");
		ObjectMapper objMapper = new ObjectMapper();
		String json = "D:\\JAVA6-2023\\Poly_Lab\\lab2_J6_duylkpc01980\\src\\main\\resources\\static\\student.json";
		Student student = objMapper.readValue(new File(json), Student.class);
		model.addAttribute("sv",student);
		return "/home/index";
	}
}
