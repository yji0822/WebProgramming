package com.lec.ex6_wrapper;

public class Ex03_method {

	public static void main(String[] args) {
		
		// ��û ���� ����!! ****
		System.out.println("(1) String�� Integer�� �ٲٴ� �Լ�: Integer.parseInt(���ڿ�)");
		int i = Integer.parseInt("10");
		System.out.println(i);
		
		// ��Ȥ���� ����
		System.out.println("(2) Integer�� String���� �ٲٴ� �Լ�: String.valueOf(����)");
		String monthStr = "" + 12; // String������ ��ȯ "12"
		monthStr = String.valueOf(12);
		System.out.println(monthStr);
		
	}

}
