/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.j6lab4.j6_lab4_duylkpc01980.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Admin
 */
public class student {

    String email;
    String fullName;
    Double marks;
    Boolean gender;
    String country;

    public student() {
    }

    public student(String email, String fullName, Double marks, Boolean gender, String country) {
        this.email = email;
        this.fullName = fullName;
        this.marks = marks;
        this.gender = gender;
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonIgnore
    public Object[] getArray() {
        return new Object[]{getEmail(), getfullName(), getMarks(), getGender(), getCountry()};
    }

}
