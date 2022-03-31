package com.lec.ex03_point;

public class Point {
	private int x;
	private int y;
	
	// ������
	public Point() { // ����Ʈ ������****
	}
	public Point(int x, int y) { // ** �����ε�(�Լ� �ߺ� ����) **
		this.x = x;
		this.y = y;
	}
	
	// Point p = new Point(1,2);
	// p.PointPrint();						��
	// System.out.println(p.infoString());	��
	// System.out.println(p);				��
	public void pointPrint() {
		System.out.println("2���� ��ǥ : x = " + x + ", y = " + y);
	} // ��
	public String infoString() {
		return "2���� ��ǥ : x = " + x + ", y = " + y;
	} // ��
	// z�� �ؼ� 3������ ����� �������� ����� �� ����..
	
	// ** �������̵� (�Լ� ������) = ��ӹ��� �Լ��� �Ű�����, ����Ÿ�� ���� **
	@Override // ������ ����� �޾Ҵµ� ������ �ȵ� ���� ������ ���� ��Ÿ���� ��.
	public String toString() { // �������̵�(toString �Լ� ������)
		return "2���� ��ǥ : x = " + x + ", y = " + y;
	}
	
	// getter & setter
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	
	
	
}
