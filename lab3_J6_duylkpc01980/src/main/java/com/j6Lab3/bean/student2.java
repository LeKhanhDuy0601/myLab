package com.j6Lab3.bean;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student2 {
	@Email(message = "Vui lòng nhập lại email")
	@NotBlank(message = "Vùi lòng không bỏ trống email")
	String email;
	@NotBlank(message = "Vùi lòng nhập Họ và tên")
	String fullName;
	@NotNull(message = "Vui lòng không bỏ trống điểm")
	@PositiveOrZero(message = "Điểm phải lớn hơn hoặc bằng 0")
	@Max(value = 10, message = "Điểm phải nhỏ hơn hoặc bằng 10")
	Double marks;
	@NotNull(message = "Chưa chọn giới tính")
	Boolean gender;
	@NotBlank(message = "Vui lòng nhập quốc tịch")
	String country;
}
