package com.j6d1.app;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.j6d1.bean.Contact;
import com.j6d1.bean.Student;
import com.j6d1.bean.Student2;

public class jackSon2 {

	public static void main(String[] args) throws Exception {
		// bai1();
		// bai2();
		// bai3();
		// bai4();
		// bai5();
		// bai6();
		bai7();
	}

	private static void bai7() throws Exception {
		Contact contact = new Contact("duylkpc01980@fpt.edu.vn", "035468469", "My xuyen, Soc Trang");
		List<String> subject = Arrays.asList("Web205", "COM108");
		Student2 student = new Student2("Le Khanh Duy", true, 7.5, contact, subject);
		ObjectMapper objMapper = new ObjectMapper();

		String json = objMapper.writeValueAsString(student);
		System.out.println(json);
		objMapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
		objMapper.writeValue(
				new File("D:\\JAVA6-2023\\Poly_Lab\\lab1_J6_duylkpc01980\\src\\main\\resources\\temp3.json"), student);

	}

	private static void bai6() throws IOException {
		Map<String, Object> contact = new HashMap<>();
		contact.put("email", "duylkpc01980@fpt.edu.vn");
		contact.put("phone", "035468469");
		contact.put("address", "My xuyen, Soc Trang");

		List<String> subject = Arrays.asList("Web205", "COM108");

		Map<String, Object> student = new HashMap<String, Object>();
		student.put("name", "Khanh Duy");
		student.put("gender", true);
		student.put("marks", 10);
		student.put("contact", contact);
		student.put("subjects", subject);

		ObjectMapper objMapper = new ObjectMapper();

		String json = objMapper.writeValueAsString(student);
		System.out.println(json);
		objMapper.writeValue(System.out, student);
		objMapper.writeValue(
				new File("D:\\JAVA6-2023\\Poly_Lab\\lab1_J6_duylkpc01980\\src\\main\\resources\\temp2.json"), student);
	}

// Tạo ra json 
	private static void bai5() throws IOException {
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode objNode = objMapper.createObjectNode();
		objNode.put("name", "Khanh Duy");
		objNode.put("gender", true);
		objNode.put("marks", 10);
		ObjectNode contact = objNode.putObject("contact");
		contact.put("email", "duylkpc01980@fpt.edu.vn");
		contact.put("phone", "035468469");
		contact.put("address", "My xuyen, Soc Trang");
		ArrayNode subject = objNode.putArray("subjects");
		subject.add("JAVA");
		subject.add("php");

		// ghi vào chuổi
		String json = objMapper.writeValueAsString(objMapper);
		// ghi vào OUTPUT
		objMapper.writeValue(System.out, objNode);
		// ghi vào file
		objMapper.writeValue(
				new File("D:\\JAVA6-2023\\Poly_Lab\\lab1_J6_duylkpc01980\\src\\main\\resources\\temp.json"), objNode);
	}

	private static void bai4() throws Exception {
		String json = "D:\\JAVA6-2023\\Poly_Lab\\lab1_J6_duylkpc01980\\src\\main\\resources\\students.json";
		TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {
		};
		ObjectMapper objMapper = new ObjectMapper();
		List<Student2> students = objMapper.readValue(new File(json), type);
		students.forEach(n -> {
			System.out.println("Name: " + n.getName());
		});

	}

	private static void bai3() throws StreamReadException, DatabindException, IOException {
		String json = "D:\\JAVA6-2023\\Poly_Lab\\lab1_J6_duylkpc01980\\src\\main\\resources\\student.json";
		ObjectMapper objMapper = new ObjectMapper();
		Student2 student = objMapper.readValue(new File(json), Student2.class);

		System.out.println("Name: " + student.getName());
		System.out.println("Gender: " + student.getGender());
		System.out.println("Marks: " + student.getMarks());
		Contact contact = student.getContact();
		System.out.println("Email: " + contact.getEmail());
		System.out.println("Phone: " + contact.getPhone());
		// MÔ TẢ MÃNG
		List<String> subjects = student.getSubjects();
		subjects.forEach(m -> {
			System.out.println("- " + m);
		});

	}

	private static void bai2() throws StreamReadException, DatabindException, IOException {
		String json = "D:\\JAVA6-2023\\Poly_Lab\\lab1_J6_duylkpc01980\\src\\main\\resources\\students.json";
		ObjectMapper objMapper = new ObjectMapper();
		List<Map<String, Object>> student = objMapper.readValue(new File(json), List.class);
		student.forEach(n -> System.out.println("Name: " + n.get("name")));
	}

	private static void bai1() throws StreamReadException, DatabindException, IOException {
		String json = "D:\\JAVA6-2023\\Poly_Lab\\lab1_J6_duylkpc01980\\src\\main\\resources\\student.json";
		ObjectMapper objMapper = new ObjectMapper();
		Map<String, Object> student = objMapper.readValue(new File(json), Map.class);

		System.out.println("Name: " + student.get("name"));
		System.out.println("Gender: " + student.get("gender"));
		System.out.println("Marks: " + student.get("marks"));
		// MÔ TẢ ĐỐI TƯỢNG
		Map<String, Object> contact = (Map<String, Object>) student.get("contact");
		System.out.println("Email: " + contact.get("email"));
		System.out.println("Phone: " + contact.get("phone"));
		// MÔ TẢ MÃNG
		List<String> subjects = (List<String>) student.get("subjects");
		subjects.forEach(m -> {
			System.out.println("- " + m);
		});

	}

}
