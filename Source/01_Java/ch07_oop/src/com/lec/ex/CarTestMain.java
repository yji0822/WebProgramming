package com.lec.ex;
public class CarTestMain {

	public static void main(String[] args) {
		Car myPorsche = new Car();
//		myPorsche.color = "Red"; 
		myPorsche.setColor("red"); //setter �����ͼ� �־��ֱ�.
//		System.out.println(myPorsche.color + "�� ��, ��ⷮ : " + myPorsche.cc 
//				+ ", �ӵ� : " + myPorsche.speed ); // color ���� ���� default�� ���
		System.out.println(myPorsche.getColor() + "�� ��, ��ⷮ : " + myPorsche.getCc() 
				+ ", �ӵ� : " + myPorsche.getSpeed() ); // color ���� ���� default�� ���
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		System.out.println(myPorsche.getSpeed()); // ���: 120 - ���̽��� �� �����̱� ������
		
		Car yourPorsche = new Car();
		yourPorsche.setColor("gray");
		yourPorsche.drive();
		yourPorsche.park();
		yourPorsche.race();
		System.out.println(yourPorsche.getSpeed());

	}

}
