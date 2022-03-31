package com.lec.ex;
// class: 데이터(속성, 인스턴스변수)와 메소드(기능, setter, getter)로 이루어져 있다.
// 데이터 하나당 setter 한개, getter 한개
// 6장에서 메소드를 이용하는 법 배운 것.
// Main()에  Car c = new car()
// c.park()
public class Car {
	private String color; // 색상
	private int    cc; // 배기량
	private int    speed; // 속도
	// 변수는 무조건 private로 잡아주고 데이터를 접근 가능하게 하는 함수(method)를 만들어준다.
	
	public void drive() {
		speed = 60;
		System.out.println(color + "색 차를 운전한다. 현재"
				+ "속도 : " + speed);
	} // drive 
	public void park() {
		speed = 0;
		System.out.println(color + "색 차를 운전한다. 현재속도: " + speed);
	}
	public void race() {
		speed = 120;
		System.out.println(color + "색 차를 운전한다. 현재속도: " + speed);	
	}
	
	// setter & getter (color, cc, speed) 
	// 1. setter
	// - 보통 일반 함수 밑에 작성을 해준다.
	// - 형식을 지키지 않으면 다른 프로그램에서 연동이 안될 수도 있다.
	// myPorsche.methodNName("red"); 이런 식으로 구현할 것
	public void setColor(String color) {
		this.color = color; // 현재 이 객체(내 객체)의 color에 private String color을 대입한다.
	} // return 값이 없으므로 void. 값만 받아오고 출력이 없으므로.
	// main에 작성을 해줘서 필요 없음...! set get은 필요시 사용하면 된다.
	public void setCc(int cc) { // myPorsche.setCc(1500); - main으로 출력할 형식
		this.cc = cc;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	// 2.getter
	public String getColor() {
		return color; // 내 객체의 color를 받아오는 것
	}
	public int getCc() {
		return cc;
	}
	public int getSpeed() {
		return speed;
	}
	
	
		

}
