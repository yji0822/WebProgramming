package com.lec.ex3_shape;

public class Rectangle extends Shape {

	// ������
	private int w; // ����
	private int h; // ����
	
	// ������ 
	public Rectangle() {
		
	}
	public Rectangle(int w, int h) {
		this.w =w;
		this.h = h;
	}
	@Override
	public double computerArea() {
		return w*h;
	}

}
