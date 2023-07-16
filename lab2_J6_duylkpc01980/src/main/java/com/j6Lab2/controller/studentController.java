package com.j6Lab2.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6Lab2.bean.students;


@Controller
public class studentController {
	@RequestMapping("/student")
	public String index(Model model, @RequestParam("index") Optional<Integer> index) throws StreamReadException, DatabindException, IOException {
		// DOC FILE JSON
		ObjectMapper objMapper = new ObjectMapper();
		File path = ResourceUtils.getFile("classpath:com/j6Lab2/bean/fileStudents.json");
		TypeReference<List<students>> typeref = new TypeReference<List<students>>() {
		};
		List<students> student = objMapper.readValue(path, typeref);
		System.err.println("Tổng: "+ student.size());
		int i = index.orElse(0);
		model.addAttribute("n",i);
		model.addAttribute("size",student.size());
		model.addAttribute("student", student.get(i));
		
		return "scope/student";
	}
}
