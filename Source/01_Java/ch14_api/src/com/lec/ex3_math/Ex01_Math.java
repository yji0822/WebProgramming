package com.lec.ex3_math;

public class Ex01_Math {

	public static void main(String[] args) {
		
		int a=2, b=10;
		
		System.out.println("2�� 10 ������? " + (int)Math.pow(a, b)); // a�� b����, doubleŸ�� - java.lang �����̶� ���� import������ �����ŵ� �ȴ�.
		System.out.println("-9.9�� ���밪��? " + Math.abs(-9-9)); // ���밪
		System.out.println("2�� ��������? " + Math.sqrt(a)); // ������
		System.out.println("a�� b �� �ּҰ���? " + Math.min(a, b)); // �ּҰ�
		System.out.println("a�� b �� �ִ밪��? " + Math.max(a, b)); // �ִ밪
		
		// �Լ��� �����ϴ� ���� �ƴ� ������ �����ϴ� Math Ŭ����! (static final ����)
		System.out.println("PI����? " + Math.PI);
		

	}

}
