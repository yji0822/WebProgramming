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
	
	// 메소드 - 같은 출력결과지만 다른 메소드 사용하여 표현
	public void pointPrint() {
		System.out.println("2차원 좌표 : x = " + x + ", y = " + y);
	}
	public String infoString() {
		return "2차원 좌표 : x = " + x + ", y = " + y;
	}
	@Override // object 클래스의 toString() 재정의 - 요소의 값을 반환하는 메소드
	public String toString() {
		return "2차원 좌표 : x = " + x + ", y = " + y;
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
