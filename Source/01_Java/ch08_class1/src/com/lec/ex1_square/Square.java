// 패키지명, 클래스명, 데이터, 생성자함수(오버로딩), 메소드, setter&getter
package com.lec.ex1_square;
public class Square {
	
	private int side;

	// public Square() {} - JVM이 자동으로 생성해준것.
	// 생성자 함수 자체가 없을 때는 JVM이 디폴트 생성자(아무것도 하지 않는 매개변수 없는 생성자)생성
	public Square() {
		System.out.println("1. 매개변수 없는 생성자 함수 호출");
	} // 생성자 함수. return type X. 데이터 초기화 하는 역할.
	// 클래스명과 같은 함수를 생성자 함수라고 말한다.
	
	public Square(int side) { // 매개변수 있는 생성자 함수 용도 : 데이터 초기화
		this.side = side; // 내 객체 side를 정해진 값으로 초기화 하고 싶은 값을 대입한다.
		System.out.println("2. 매개변수 있는 생성자 함수 호출. side 초기화");
	} // 매개변수 없는 생성자라도 꼭 기본으로 만들어놓자!
	
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
