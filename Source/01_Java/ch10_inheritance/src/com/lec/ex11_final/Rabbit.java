package com.lec.ex11_final;
// Animal로부터 speed, running(), stop() 상속받음
public final class Rabbit extends Animal { // 다른 곳에 상속을 받을 수는 없지만 상속을 받아올 수는 있다.

	@Override
	public void running() {
		setSpeed(getSpeed() + 30); // speed += 30;
		System.out.println("마구 뛰어요. 현재속도: " + getSpeed());
	}
	
	/*
	 * 에러
	public void stop() {
		
	}
	*/
	
}
