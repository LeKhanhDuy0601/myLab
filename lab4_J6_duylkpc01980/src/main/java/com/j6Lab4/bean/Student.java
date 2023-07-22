package com.j6Lab4.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    String email;
    String fullName;
    Double marks;
    Boolean gender;
    String country;
}
