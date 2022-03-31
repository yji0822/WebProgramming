package com.lec.ex4_object;

public class Ex04_RectangleTestMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Rectangle r1 = new Rectangle();
		
		System.out.println(r1);
		
		r1.setHeight(10);
		r1.setWidth(5);
		System.out.println(r1);
		
		Rectangle r2 = (Rectangle) r1.clone();
		System.out.println(r1.equals(r2) ? "r1�� r2�� ���� �簢��" : "r1�� r2�� �ٸ� �簢��");
		System.out.println(r1==r2 ? "�����Ѱ� �ƴϰ� ���� �ּҸ� ����Ŵ" : "�ٸ� �ּҸ� ����Ŵ");

		// �����ϴ� ��
		// clone() �������̵�. �������̽� �߰�.
		// ���� ���� Ȯ��
		if(r1!=r2 && r1.equals(r2)) {
			System.out.println("��������!");
		} else {
			System.out.println("��������");
		}
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
		
	}

}
