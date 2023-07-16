package com.j6d1.app;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jackSon1 {
	public static void main(String[] args) throws Exception {
		bai2();
	}

	private static void bai2() throws IOException {
		String json = "D:\\JAVA6-2023\\Poly_Lab\\lab1_J6_duylkpc01980\\src\\main\\resources\\students.json";
		ObjectMapper objMapper = new ObjectMapper();
		JsonNode Students = objMapper.readTree(new File(json));
		Students.iterator().forEachRemaining(n -> {
			System.out.println("Name: " + n.get("name").asText());
		});
		
	}

	private static void bai1() throws Exception {
		String json = "D:\\JAVA6-2023\\Poly_Lab\\lab1_J6_duylkpc01980\\src\\main\\resources\\student.json";
		ObjectMapper objMapper = new ObjectMapper();
		JsonNode student = objMapper.readTree(new File(json));
			System.out.println("name: "+student.get("name").asText());
			System.out.println("Gender: "+student.get("gender").asBoolean());
			System.out.println("Marks: "+student.get("marks").asDouble());
			System.out.println("Contact: \n Email: "+student.get("contact").get("email").asText());
			System.out.println(" phone: "+student.get("contact").get("phone").asText());
			System.out.println(" Address: "+student.findValue("address").asText());
			System.out.println("Subjects: ");
			student.get("subjects").iterator().forEachRemaining(n -> {
				String subject = n.asText();
				System.out.println(" "+subject);
			});

		
	}
}
