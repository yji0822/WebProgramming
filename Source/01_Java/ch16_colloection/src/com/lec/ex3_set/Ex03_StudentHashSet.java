package com.lec.ex3_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {

	public static void main(String[] args) {
		
		HashSet<Student> students = new HashSet<Student>(); // size가 0인 HashSet
		Student s = new Student(6, "이순신");
		students.add(s);
		students.add(s); // 위의 s 해시코드와 같은 것이기 때문에 같은 이순신으로 인식 - 출력안됨
		System.out.println(students);
		
		students.add(new Student(3, "홍길동"));
		System.out.println(students);
		
		students.add(new Student(3, "홍길동")); // 위의 홍길동과 다른 hashcode를 가지고 있으므로 다른 홍길동으로 인식
		System.out.println(students);
		
		students.add(new Student(6, "이순신")); // 다른 이순신으로 인식
		System.out.println(students);
		
		// 같은 이순신으로 인식해서 출력하고 싶다면? 
		// 1) equals() 오버라이드 해주기 2) hashcode()도 출력해서 같은지 확인
		// - Student.java로 가기

	}

}
