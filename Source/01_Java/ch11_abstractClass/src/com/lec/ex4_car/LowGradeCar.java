package com.lec.ex4_car;
// LowGradeCar : tax, color(블루), tire(일반타이어), displacement(2000), handle(파워핸들), getSpec()
// Car c = new LowGradeCar("빨강", "광폭", 1490, "파워");
public class LowGradeCar extends Car {
	private int tax; // 자동차세
	
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 50000; // 생성자에서 데이터 초기화
	} 

	// 추상클래스로 와서 구현을 해줘야 한다!
	@Override
	public void getSpec() { // spec들 (색상, 타이어, 배기량, 핸들, 세금) 을 출력
		// 세금 금액 측정
		if(getDisplacement() > 1000) {
			tax += (getDisplacement()-1000)*100;
		} // 5만원은 초기화 해서 상관 X
		System.out.println("색상    : " + getColor());
		System.out.println("타이어 : " + getTire());
		System.out.println("배기량 : " + getDisplacement() + "cc");
		System.out.println("핸들    : " + getHandle());
		System.out.println("세금    : " + tax + "원");
		System.out.println("----------------");
	}

}
