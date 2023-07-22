package com.j6Lab4.dao;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.j6Lab4.bean.Student;
import com.j6Lab4.map.StudentMap;

@Repository
public class StudentDao {
	RestTemplate rest = new RestTemplate();

	String path = "https://duylkpc0190-lab-default-rtdb.firebaseio.com/student.json";

	public String getPath(String key) {
		return path.replace(".json", "/" + key + ".json");
	}
	
	public StudentMap fillAll() {
		return rest.getForObject(path,StudentMap.class);
	}
	
	public Student findByKey(String key) {
		return rest.getForObject(getPath(key), Student.class);
	}
	
	public String create(Student data) {
		HttpEntity<Student> entity = new HttpEntity<>(data);
		JsonNode resp = rest.postForObject(path, entity, JsonNode.class);
		return resp.get("name").asText();
	}
	
	public Student update(String key, Student data) {
		HttpEntity<Student> entity = new HttpEntity<>(data);
		rest.put(getPath(key), entity);
		return data;
	}
	
	public void delete(String key) {
		rest.delete(getPath(key));
	}
}
