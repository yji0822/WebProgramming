package com.lec.ex03_protectedmember;

public class SuperIJ {
	// ������
	private int i;
	private int j;
	
	// ������
	public SuperIJ() {
		System.out.println("�Ű����� ���� SuperIJ ������");
	}
	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("�Ű����� �ִ� SuperIJ ������ �Լ�. i&j�� �ʱ�ȭ");
	}
	
	// getter&setter
	protected int getI() {
		return i;
	}
	protected void setI(int i) {
		this.i = i;
	}
	protected int getJ() {
		return j;
	}
	protected void setJ(int j) {
		this.j = j;
	}
	
}
