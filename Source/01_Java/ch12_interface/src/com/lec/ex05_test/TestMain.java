package com.lec.ex05_test;

public class TestMain {

	public static void main(String[] args) {
		
		TestChildClass obj = new TestChildClass(); // ������ �ִ� ��ü ��� ��� ����
		obj.m1();
		obj.m2();
		obj.m3();
		obj.m11();
		System.out.println(I11.i11); //Ŭ������.static����
		System.out.println(I3.i3);
		System.out.println(I1.i1); // ��ӹ޾Ƽ� ��� ��� ��

	}

}
