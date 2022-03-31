package com.lec.quiz02_0331;

public class Main {

	public static void main(String[] args) {
		
		Person[] persons = { new Student("A01", "나학생", "JAVA반"),
							 new Student("A02", "홍길동", "C++반"),
							 new Staff("S01", "나직원", "교무팀"),
							 new Staff("S02", "나도요", "취업지원팀"),
							 new Gangsa("G01", "나선생", "프로그래밍") };
		// 출력 - 확장for문
		for(Person p : persons) {
			System.out.println(p);
		} // for

	} // main
} // class
