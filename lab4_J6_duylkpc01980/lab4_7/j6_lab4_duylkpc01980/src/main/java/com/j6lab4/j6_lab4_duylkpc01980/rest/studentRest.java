/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.j6lab4.j6_lab4_duylkpc01980.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Admin
 */
public class studentRest {
     private static ObjectMapper ObjMapper = new ObjectMapper();

    public static JsonNode get(String path) {
        return request("GET", path, null);
    }

    public static JsonNode post(String path, Object data) {
        return request("POST", path, data);
    }

    public static JsonNode put(String path, Object data) {
        return request("PUT", path, data);
    }

    public static void delete(String path) {
        request("DELETE", path, null);
    }
    
    private static JsonNode request(String method, String pathStudent, Object data) {
        try {
            String path = "https://duylkpc0190-lab-default-rtdb.firebaseio.com" + pathStudent + ".json";
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod(method);
            //post and put
            if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")) {
                conn.setDoOutput(true);
                ObjMapper.writeValue(conn.getOutputStream(), data);
            }
            
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                return ObjMapper.readTree(conn.getInputStream());
            }
            conn.disconnect();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
