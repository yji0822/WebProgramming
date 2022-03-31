package com.lec.ex04_point;

public class Point {
	private int x;
	private int y;
	 
	public Point() {
		
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// �޼ҵ� - ���� ��°������ �ٸ� �޼ҵ� ����Ͽ� ǥ��
	public void pointPrint() {
		System.out.println("2���� ��ǥ : x = " + x + ", y = " + y);
	}
	public String infoString() {
		return "2���� ��ǥ : x = " + x + ", y = " + y;
	}
	@Override // object Ŭ������ toString() ������ - ����� ���� ��ȯ�ϴ� �޼ҵ�
	public String toString() {
		return "2���� ��ǥ : x = " + x + ", y = " + y;
	}
	
	// getter&setter
	protected int getX() {
		return x;
	}
	protected void setX(int x) {
		this.x = x;
	}
	protected int getY() {
		return y;
	}
	protected void setY(int y) {
		this.y = y;
	}
	
	

}
