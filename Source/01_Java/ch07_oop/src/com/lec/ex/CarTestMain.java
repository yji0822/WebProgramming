package com.lec.ex;
public class CarTestMain {

	public static void main(String[] args) {
		Car myPorsche = new Car();
//		myPorsche.color = "Red"; 
		myPorsche.setColor("red"); //setter 가져와서 넣어주기.
//		System.out.println(myPorsche.color + "색 차, 배기량 : " + myPorsche.cc 
//				+ ", 속도 : " + myPorsche.speed ); // color 값만 넣은 default값 출력
		System.out.println(myPorsche.getColor() + "색 차, 배기량 : " + myPorsche.getCc() 
				+ ", 속도 : " + myPorsche.getSpeed() ); // color 값만 넣은 default값 출력
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		System.out.println(myPorsche.getSpeed()); // 출력: 120 - 레이스를 한 이후이기 때문에
		
		Car yourPorsche = new Car();
		yourPorsche.setColor("gray");
		yourPorsche.drive();
		yourPorsche.park();
		yourPorsche.race();
		System.out.println(yourPorsche.getSpeed());

	}

}
