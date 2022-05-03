package com.lec.ex3_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {

	public static void main(String[] args) {
		
		HashSet<Student> students = new HashSet<Student>(); // size�� 0�� HashSet
		Student s = new Student(6, "�̼���");
		students.add(s);
		students.add(s); // ���� s �ؽ��ڵ�� ���� ���̱� ������ ���� �̼������� �ν� - ��¾ȵ�
		System.out.println(students);
		
		students.add(new Student(3, "ȫ�浿"));
		System.out.println(students);
		
		students.add(new Student(3, "ȫ�浿")); // ���� ȫ�浿�� �ٸ� hashcode�� ������ �����Ƿ� �ٸ� ȫ�浿���� �ν�
		System.out.println(students);
		
		students.add(new Student(6, "�̼���")); // �ٸ� �̼������� �ν�
		System.out.println(students);
		
		// ���� �̼������� �ν��ؼ� ����ϰ� �ʹٸ�? 
		// 1) equals() �������̵� ���ֱ� 2) hashcode()�� ����ؼ� ������ Ȯ��
		// - Student.java�� ����

	}

}
