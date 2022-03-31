package com.lec.ex03_point;

public class Point {
	private int x;
	private int y;
	
	// 생성자
	public Point() { // 디폴트 생성자****
	}
	public Point(int x, int y) { // ** 오버로딩(함수 중복 정의) **
		this.x = x;
		this.y = y;
	}
	
	// Point p = new Point(1,2);
	// p.PointPrint();						①
	// System.out.println(p.infoString());	②
	// System.out.println(p);				③
	public void pointPrint() {
		System.out.println("2차원 좌표 : x = " + x + ", y = " + y);
	} // ①
	public String infoString() {
		return "2차원 좌표 : x = " + x + ", y = " + y;
	} // ②
	// z로 해서 3차원을 만들고 싶을때는 사용할 수 없음..
	
	// ** 오버라이드 (함수 재정의) = 상속받은 함수의 매개변수, 리턴타입 동일 **
	@Override // 위에서 상속을 받았는데 마음에 안들어서 새로 세팅한 것을 나타내는 것.
	public String toString() { // 오버라이드(toString 함수 재정의)
		return "2차원 좌표 : x = " + x + ", y = " + y;
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
