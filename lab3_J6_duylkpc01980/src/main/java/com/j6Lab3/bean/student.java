package com.j6Lab3.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student {
	String email;
	String fullName;
	Double marks;
	Boolean gender;
	String country;
}
