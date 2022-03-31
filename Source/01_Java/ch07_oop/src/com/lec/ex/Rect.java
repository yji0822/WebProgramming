package com.lec.ex;
// 데이터(private) -width/height, 메소드(public)-area(), setter&getter
// Rect r1 = new Rect();
public class Rect {
	private int width;
	private int height;
	
	public int area() {
		return width * height; // area 함수는 width*height을 출력해주는 함수.
	}
	
	// setter
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	// getter
	public int getWidth(int width) {
		return width;
	}
	public int getHeight(int height) {
		return height;
	}
	
	
	
}
