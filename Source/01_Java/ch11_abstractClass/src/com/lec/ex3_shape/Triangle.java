package com.lec.ex3_shape;

public class Triangle extends Shape {
	private int w; // �غ�
	private int h; // ����
	
	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	@Override
	public double computerArea() {
		return w*h*0.5;
	} // ����Ÿ���̶� �Ű����� ��ġ

}
