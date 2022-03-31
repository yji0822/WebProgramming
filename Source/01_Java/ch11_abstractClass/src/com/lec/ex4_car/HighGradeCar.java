package com.lec.ex4_car;

public class HighGradeCar extends Car {
	
	private int tax;
	
	public HighGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 150000; // 세금의 금액을 올린
	}

	@Override
	public void getSpec() {
		if(getDisplacement() > 1800) {
			tax += (getDisplacement()-1800) * 300;
		} 
		System.out.println("색상    : " + getColor());
		System.out.println("타이어 : " + getTire());
		System.out.println("배기량 : " + getDisplacement() + "cc");
		System.out.println("핸들    : " + getHandle());
		System.out.println("세금    : " + tax + "원");
		System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
	}

}
