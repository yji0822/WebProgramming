package com.lec.ex1_string;

import java.util.Scanner;

public class Ex03_equal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String fn;
		
		do {
			System.out.println("I : input | U : update | X : exit");
			fn = sc.next(); // �����̽��� tap�� ���� ������ �Է� �޴´�. - XxIiUu or etc..
			switch(fn) {
			case "i":
			case "I":
				System.out.println("input ���� ���� ��");
				break;
			case "u":
			case "U":
				System.out.println("update ���� ���� ��");
				break;
			case "X":
			case "x":
				System.out.println("exit ���� ���� ��");
			}
		} while(!fn.equalsIgnoreCase("x"));
		System.out.println("done");
		
		
		sc.close();
		
	}

}
