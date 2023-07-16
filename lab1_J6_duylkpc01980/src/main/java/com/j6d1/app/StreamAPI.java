package com.j6d1.app;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.j6d1.bean.Student;

public class StreamAPI {
	static List<Student> list = Arrays.asList(new Student("Nguyen Van Teo", true, 7.5),
			new Student("Nguyen Thi No", false, 9.5), new Student("Chi Pheo", true, 5.0),
			new Student("Lao Hac", true, 8.5), new Student("Thuy Kieu", false, 4.5));

	public static void main(String[] args) {
		// bai1();
		// bai2();
		// bai3();
		bai4();
	}

	private static void bai4() {
		double average = list.stream()
				.mapToDouble(sv -> sv.getMarks())
				.average().getAsDouble();
		System.out.println("AVERAGE: "+average);
		double sum = list.stream()
				.mapToDouble(n -> n.getMarks())
				.sum();
		System.err.println("SUM MARKS: "+sum);
		double min_marks = list.stream()
				.mapToDouble(n -> n.getMarks())
				.min().getAsDouble();
		System.out.println("MIN MARSK: "+min_marks);
		boolean all_passed = list.stream()
				.allMatch(n -> n.getMarks() >= 5);
		System.err.println("ALL PASSED: "+all_passed);
		Student min_sv = list.stream()
				.reduce(list.get(0), (min,sv) -> sv.getMarks() < min.getMarks() ? sv:min);
		System.out.println("MIN SV: "+min_sv);
		
		
	}

	private static void bai3() {
		List<Student> result = list.stream()
				.filter(n -> n.getMarks() >= 7)
				.peek(n -> n.setName(n.getName().toUpperCase()))
				.collect(Collectors.toList());
		result.forEach(n -> {
			System.out.println("Name: "+n.getName()+", Marks: "+n.getMarks());
		});

	}

	private static void bai2() {
		List<Integer> list = Arrays.asList(1, 5, 6, 8, 2, 4);
		List<Double> result = list.stream().filter(n -> n % 2 == 0).map(n -> Math.sqrt(n))
				.peek(n -> System.out.println(n)).collect(Collectors.toList());
		// colect là chuyển đổi dử liệu thành double

	}

	private static void bai1() {
		Stream<Integer> stream1 = Stream.of(1, 5, 6, 8, 2, 4);
		stream1.forEach(n -> System.out.print(n));
		System.out.println();
		System.err.println("\n ************");
		List<Integer> list = Arrays.asList(1, 5, 6, 8, 2, 4);
		list.stream().forEach(n -> {
			System.out.print(n);
		});
	}

}
