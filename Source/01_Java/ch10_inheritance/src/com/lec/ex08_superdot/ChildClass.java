package com.lec.ex08_superdot;
//super. :  �� �θ����
//super() : �� �θ���� ������ �Լ� **** ��¥ ���� ���δ�
public class ChildClass extends ParentClass { // ParentClass - i, method()
	
	private int i = 99;

	// ������
	public ChildClass() {
		System.out.println("ChildClass ����Ʈ ������");
	}
	
	// �޼ҵ� - �������̵�
	@Override
	public void method() {
		System.out.println("ChildClass�� method");
		super.method(); // ���� method�� �ƴ� �θ�Ŭ������ method
		System.out.println("ChildClass���� super�� i = " + super.getI()
							+ ", Child ���� i = " + i);
	} // i �� private�� �س��ұ� ������ getI()�� �޾ƿ;� �Ѵ�.

	public int getI() {
		return i;
	} // child���� i��!
	
	

}
