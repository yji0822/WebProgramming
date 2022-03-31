// ��Ű����, Ŭ������, ������, �������Լ�(�����ε�), �޼ҵ�, setter&getter
package com.lec.ex1_square;
public class Square {
	
	private int side;

	// public Square() {} - JVM�� �ڵ����� �������ذ�.
	// ������ �Լ� ��ü�� ���� ���� JVM�� ����Ʈ ������(�ƹ��͵� ���� �ʴ� �Ű����� ���� ������)����
	public Square() {
		System.out.println("1. �Ű����� ���� ������ �Լ� ȣ��");
	} // ������ �Լ�. return type X. ������ �ʱ�ȭ �ϴ� ����.
	// Ŭ������� ���� �Լ��� ������ �Լ���� ���Ѵ�.
	
	public Square(int side) { // �Ű����� �ִ� ������ �Լ� �뵵 : ������ �ʱ�ȭ
		this.side = side; // �� ��ü side�� ������ ������ �ʱ�ȭ �ϰ� ���� ���� �����Ѵ�.
		System.out.println("2. �Ű����� �ִ� ������ �Լ� ȣ��. side �ʱ�ȭ");
	} // �Ű����� ���� �����ڶ� �� �⺻���� ��������!
	
	public int area() {
		return side*side;
	}
	
	// setter & getter 
	public void setSide(int side) {
		this.side = side;
	}
	
	public int getSide() {
		return side;
	}
	

	
}
