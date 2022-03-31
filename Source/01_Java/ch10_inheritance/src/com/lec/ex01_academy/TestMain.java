package com.lec.ex01_academy;

public class TestMain {

	public static void main(String[] args) {
		
		Person s1 = new Student ("A01", "홍길동", "Java");
		Person s2 = new Student("A02", "강유미", "C++");
		Person sf1 = new Staff("S01", "유길동", "운영지원팀");
		Person sf2 = new Staff("s02", "유미", "취업지원팀");
		Person ga1 = new Gangsa("G01", "이길동", "객체지향");
		
		Person[] person = {s1, s2, sf1, sf2, ga1};
		
		for(Person pp : person) {
			pp.print();
		}

	}

}
