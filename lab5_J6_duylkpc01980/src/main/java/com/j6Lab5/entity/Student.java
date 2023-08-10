package com.j6Lab5.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Students")
public class Student {
	@Id
	String email;
	String fullname;
	Double marks;
	Boolean gender;
	String country;
}
