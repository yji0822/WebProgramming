package com.lec.ex2;

public abstract class SuperClass { // 추상메소드 반드시 하나 이상 들어가야 하는 추상클래스..!

	// 추상클래스는 객체 못만든다!
	
	public abstract void method1(); // 추상메소드 - 상속받은 클래스에서 구현(오버라이드)
	
	public void method2() { // 일반메소드 - 상속받은 아이가 오버라이드 하고싶으면 하고 말고 싶으면 말고
		System.out.println("SuperClass의 method2");
	}
		
}
