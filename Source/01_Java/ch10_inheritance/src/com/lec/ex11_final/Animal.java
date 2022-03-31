package com.lec.ex11_final;

public class Animal {
	
	protected int speed;

	// 메소드
	public void running() {
		speed += 5;
		System.out.println("뛰고 있어요. 현재속도: " + speed);
	}
	public final void stop() { // override 금지 메소드 - 멈춤은 무조건 속도가 0!!
		speed = 0;
		System.out.println("멈춤");
	}

	// getter setter 
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	

}
