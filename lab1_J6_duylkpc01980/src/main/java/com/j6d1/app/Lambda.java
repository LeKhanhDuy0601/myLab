package com.j6d1.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.j6d1.bean.Student;

public class Lambda {
	static List<Student> list = Arrays.asList(new Student("Nguyen Van Teo", true, 7.5),
			new Student("Nguyen Thi No", false, 9.5), new Student("Chi Pheo", true, 5.0),
			new Student("Lao Hac", true, 8.5), new Student("Thuy Kieu", false, 6.5));

	public static void main(String[] args) {
		// bai1();
		// bai2();
		// bai3();
		demo4();
	}

	private static void demo4() {
//		cách 1
//		DemoBai4Inter o = (int x) -> {
//			System.out.println(x);
//		};
		// cách 2
		DemoBai4Inter o = (int x)-> System.out.println(x);
		o.m1(2021);
	}

	private static void bai3() {
		System.err.println("So Sánh Tăng Dần");
		Collections.sort(list, (sv1, sv2) -> sv1.getMarks().compareTo(sv2.getMarks()));
		list.forEach(sv -> {
			System.out.println("Name: " + sv.getName() + " Mark: " + sv.getMarks());
			System.err.println();
		});
		System.err.println("So Sánh giảm Dần");
		Collections.sort(list, (sv1, sv2) -> -sv1.getMarks().compareTo(sv2.getMarks()));
		list.forEach(sv -> {
			System.out.println("Name: " + sv.getName() + " Mark: " + sv.getMarks());
			System.err.println();
		});
	}

	private static void bai2() {

		list.forEach(sv -> System.out
				.print("Name: " + sv.getName() + ", Gender: " + sv.getGender() + ", Marks: " + sv.getMarks() + "\n"));

	}

	private static void bai1() {
		List<Integer> list = Arrays.asList(9, 6, 8, 1, 7);
		list.forEach(n -> System.err.print(n + " "));

	}

}

@FunctionalInterface
interface DemoBai4Inter {
	void m1(int x);

	default void m2() {
	};

	public static void m3() {

	}
}
