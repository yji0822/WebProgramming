package com.lec.ex06;

public class TestMain2 {

	public static void main(String[] args) {
//		Child1 c1 = new Child1(10);
		Super c1 = new Child1(10);
		System.out.println("c1.s = " + c1.s);
//		System.out.println(c1.c1); - �����Ͽ��� // c1�� Ÿ���� ���� Super�̱� ������ SuperŬ���� ���� �޼ҵ常 ���� �����ϴ�
		System.out.println(((Child1)c1).c1); // �ذ��� - c1 ��ü ������ ����� ����ȯ

	}

}
