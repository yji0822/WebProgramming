package com.lec.ex3_shape;
// Shape를 통해 Rect(height, width), Traiangle(w, h), Circle(r)를 잘 쓰고자 함
public abstract class Shape { // 추상클래스 - 쓰기 좋도록 틀을 만들어준다고 생각하면 됨
	// 데이터X
	// 메소드
	public void draw() {
		String className = this.getClass().getName(); // com.lec.ex3_shape.Circle
		// -> Circle만 빼오고
		System.out.println(this.getClass().getName() + "도형을 그려요");
		// 내 객체의 클래스를 가져와서 그 클래스의 이름을 뿌려라! 라는 의미
	}
	
	public abstract double computerArea(); // 추상메소드 
	// 사각형인지 삼각형인지 원형인지 계산하는 법은 각 childclass에서 확인해라

}
