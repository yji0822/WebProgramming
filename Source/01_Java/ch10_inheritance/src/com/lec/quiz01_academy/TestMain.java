package com.lec.quiz01_academy;

public class TestMain {

	public static void main(String[] args) {
		Person st1 = new Student("A01", "������", "�ڹ�");
		Person st2 = new Student("A02", "ȫ�浿", "�ڹ�");
		Person sf1 = new Staff("S01", "���浿", "�������");
		Person sf2 = new Staff("S02", "���浿", "���������");
		Person ga1 = new Gangsa("G01", "�̱浿", "��ü����");

		Person[] p = {st1, st2, sf1, sf2, ga1};
	
		for(Person pp : p) {
			pp.print();
		}
		
	

	}

}
