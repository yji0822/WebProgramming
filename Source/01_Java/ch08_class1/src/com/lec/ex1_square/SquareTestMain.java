package com.lec.ex1_square;

public class SquareTestMain {

	public static void main(String[] args) {
		
		Square s1 = new Square(); // �Ű����� ���� ����Ʈ ������ - 0
		System.out.println("s1�� �Ѻ��� ����: " + s1.getSide());
		s1.setSide(5);
		System.out.println("s1�� �Ѻ��� ����: " + s1.getSide());
		System.out.println("s1�� ����: " + s1.area());
		
		Square s2 = new Square(10); // �Ű����� �ִ� ������. side�� 10���� �ʱ�ȭ�� �Ű������� �ִ� ������
		System.out.println("s2�� �Ѻ��� ����: " + s2.getSide());
		System.out.println("s2�� ����: " + s2.area());
		
	}

}
