package com.lec.ex08_superdot;
// super. :  �� �θ����
// super() : �� �θ���� ������ �Լ� **** ��¥ ���� ���δ�
public class ParentClass {
	
	private int i = 20;
	
	// ������
	public ParentClass() {
		System.out.println("ParentClass default ������");
	}
	
	// method
	public void method() {
		System.out.println("ParentClass�� method, super ���� i�� " + i);
	}
	
	// getter
	public int getI() {
		return i;
	}


}
