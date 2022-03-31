package com.lec.ex4_object;
// Rectangle r1 = new Rectangle(10, 5, "검정");
// default color = "검정"
// Rectangle r1 = new Rectangle();
public class Rectangle implements Cloneable {
	
	private int width;
	private int height;
	private String color;
	
	// 생성자
	public Rectangle() {
		color = "검정"; // 아무것도 세팅하지 않았다면 색만 검정으로 자동 세팅 되도록
	}
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		color = "검정";
	}
	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	// 메소드
	@Override
	public String toString() {
//		return "가로 " + width + "cm, 세로 " + height + "cm인 " + color + "색 사각형";
		return String.format("가로 %dcm, 세로 %dcm인 %s색 사각형", width, height, color);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Rectangle) {
			Rectangle tempObj = (Rectangle)obj;
			boolean widthChk = width == tempObj.width;
			boolean heightChk = height == tempObj.height;
			boolean colorChk = color.equals(tempObj.color); 
			// string의 equals임. 걍 논리연산식이랑 같음
			return widthChk && heightChk && colorChk;
		} else {
			return false;
		}	
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 예외처리가 될 수도 있다 라는 의미
		return super.clone();
	}
	
	// setter
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
	
	
}
