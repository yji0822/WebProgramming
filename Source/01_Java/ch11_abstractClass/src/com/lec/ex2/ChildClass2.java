package com.lec.ex2;
// method1(추상메소드), method2(일반메소드)
public abstract class ChildClass2 extends SuperClass {
// superclass를 오버라이드 하고 싶지 않을때...! 는 똑같이 abstract를 적어준다
	
	@Override
		public void method2() {
		System.out.println("ChildClass2의 method2 - 일반메소드 친구지만 그냥 메소드 함");
		}

}
