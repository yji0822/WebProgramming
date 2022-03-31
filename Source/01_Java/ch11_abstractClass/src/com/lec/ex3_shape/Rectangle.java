package com.lec.ex3_shape;

public class Rectangle extends Shape {

	// 데이터
	private int w; // 가로
	private int h; // 세로
	
	// 생성자 
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
