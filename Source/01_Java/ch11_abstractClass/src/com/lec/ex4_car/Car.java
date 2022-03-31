package com.lec.ex4_car;
// Car : color, tire, displacement, handle, getSpec()
public abstract class Car {
	
	private String color;
	private String tire; // 타이어
	private int displacement; // 배기량
	private String handle; // 핸들
	
	// 생성자
	public Car(String color, String tire, int displacement, String handle) {
		super();
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	
	// 메소드
	public abstract void getSpec(); // 추상메소드 - 잊지말고 다른 클래스에서 구현을 해라!

	public String getColor() {
		return color;
	}

	// getter&setter
	public void setColor(String color) {
		this.color = color;
	}

	public String getTire() {
		return tire;
	}

	public void setTire(String tire) {
		this.tire = tire;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	

}
