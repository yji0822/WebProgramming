package com.lec.ex1_string;

public class Ex09_StringmemoryWaste {

	public static void main(String[] args) {
		// String ������ ���� �ٲ� ������ ��ü�� ���Ӱ� �����˴ϴ�.
		String str1 = "Hello";
		String str2 = "Hello";
		
		System.out.println(str1==str2 ? "���� �ּ�" : "�ٸ� �ּ�");
		
		// hashCode() - �ּ� �񽺹����Ѱ��� ����ִ� �Լ�
		System.out.println("str1�� �ؽ��ڵ� : " + str1.hashCode());
		System.out.println("str2�� �ؽ��ڵ� : " + str2.hashCode());
		
		str1 = "Hello~"; // ������ ��ü�� ������ ���ο� ��ü�� �����ϴ� String ����
		System.out.println("str1�� �ؽ��ڵ�(����1) : " + str1.hashCode());
		System.out.println(str1==str2? "���� �ּ�" : "�ٸ� �ּ�");
		
		str1 = "Hello!!!";
		System.out.println("str1�� �ؽ��ڵ�(����2) : " + str1.hashCode());
		str1 = "HELLO";
		System.out.println("str1�� �ؽ��ڵ�(����3) : " + str1.hashCode());
		
	}
	

}
