package com.lec.ex1_square;

public class SquareTestMain {

	public static void main(String[] args) {
		
		Square s1 = new Square(); // 매개변수 없는 디폴트 생성자 - 0
		System.out.println("s1의 한변의 길이: " + s1.getSide());
		s1.setSide(5);
		System.out.println("s1의 한변의 길이: " + s1.getSide());
		System.out.println("s1의 넓이: " + s1.area());
		
		Square s2 = new Square(10); // 매개변수 있는 생성자. side에 10으로 초기화한 매개변수가 있는 생성자
		System.out.println("s2의 한변의 길이: " + s2.getSide());
		System.out.println("s2의 넓이: " + s2.area());
		
	}

}
