package com.lec.ex;

// import java.util.Scanner;

public class RectTestMain {

	public static void main(String[] args) {
		// Rect();
		Rect r1 = new Rect(); // �޸𸮿� ������Ű�� ���� new
		r1.setWidth(10);
		r1.setHeight(5);
		System.out.println("r1�� ���̴� " + r1.area());
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("r1 ����: ");
//		r1.setWidth(sc.nextInt());
//		System.out.print("r1 ����: ");
//		r1.setHeight(sc.nextInt());
//		System.out.println("r1�� ����: " + r1.area());
		
		Rect r2 = new Rect();
		System.out.println("r2�� ���̴� " + r2.area());
		System.out.println("r2�� ���̴� " + r2.area());
		// ctrl+alt+����Ű - ���� ����
		
		
//		sc.close();
	}
	
}
