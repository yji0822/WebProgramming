package com.lec.ex01_academy;

public class TestMain {

	public static void main(String[] args) {
		
		Person s1 = new Student ("A01", "ȫ�浿", "Java");
		Person s2 = new Student("A02", "������", "C++");
		Person sf1 = new Staff("S01", "���浿", "�������");
		Person sf2 = new Staff("s02", "����", "���������");
		Person ga1 = new Gangsa("G01", "�̱浿", "��ü����");
		
		Person[] person = {s1, s2, sf1, sf2, ga1};
		
		for(Person pp : person) {
			pp.print();
		}

	}

}
