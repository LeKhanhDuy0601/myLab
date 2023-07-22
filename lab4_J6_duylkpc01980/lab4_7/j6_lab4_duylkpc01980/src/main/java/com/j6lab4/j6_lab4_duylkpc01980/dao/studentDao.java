/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.j6lab4.j6_lab4_duylkpc01980.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6lab4.j6_lab4_duylkpc01980.bean.student;
import com.j6lab4.j6_lab4_duylkpc01980.bean.studentMap;

import com.j6lab4.j6_lab4_duylkpc01980.rest.studentRest;

/**
 *
 * @author Admin
 */
public class studentDao {

    ObjectMapper ObjMapper = new ObjectMapper();

    public studentMap findAll() {
        JsonNode resp = studentRest.get("/student");
        return ObjMapper.convertValue(resp, studentMap.class);
    }

    public student findByKey(String key) {
        JsonNode resp = studentRest.get("/student/" + key);
        return ObjMapper.convertValue(resp, student.class);
    }

    public String create(student data) {
        JsonNode resp = studentRest.post("/student", data);
        return resp.get("name").asText();
    }

    public student update(String key, student data) {
        JsonNode resp = studentRest.put("/student/" + key, data);
        return ObjMapper.convertValue(resp, student.class);
    }

    public void delete(String key) {
        studentRest.delete("/student/" + key);
    }
}
