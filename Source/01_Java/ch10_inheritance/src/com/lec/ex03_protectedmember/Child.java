package com.lec.ex03_protectedmember;

public class Child extends SuperIJ {
	private int total;
	public Child() {
		System.out.println("�Ű����� ���� Child ������ �Լ�");
	}
	public Child(int i, int j) {
		setI(i);
		setJ(j);
		System.out.println("�Ű����� �ִ� Child ������ �Լ�");
	}
	//�޼ҵ�
	public void sum() {
		total  = getI() + getJ();
		System.out.println("�� ��ü�� i = " + getI() + ", j = " + getJ());
		System.out.println("�� ��ü�� total = " + total);
	}
}
