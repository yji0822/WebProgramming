package com.lec.ex02_protectedmember;
// ������ - ������ - �޼ҵ� - �������̵� �޼ҵ�(�ٽ� �����Ѵ�) - setter&getter ������� ����� �־�� �Ѵ�.
public class SuperIJ {
	private int i;
	private int j;
	
	// ������ - �⺻ ������ �ʱ�ȭ!!!
	// ��ӹ��� Ŭ�������� Super Ŭ����(�θ��) ������ �Լ��� ���� ȣ��
	// ����� ���� ����Ǵ��� Ȯ�� �غ���!
	public SuperIJ() {
		System.out.println("�Ű����� ���� �� SuperIJ ������ �Լ�");
	}
	
	public SuperIJ(int i, int j) {
		super();
		this.i = i;
		this.j = j;
		System.out.println("�Ű����� �ִ� SuperIJ ������ �Լ��� i, j�� �ʱ�ȭ");
	}

	// setter & getter
	protected int getI() { // protected
		return i;
	}
	protected void setI(int i) {
		this.i = i;
	}
	protected int getJ() {
		return j;
	}
	public void setJ(int j) { // public
		this.j = j;
	} 
	
	
	
	
	
}
