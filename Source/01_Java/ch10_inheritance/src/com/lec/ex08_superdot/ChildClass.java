package com.lec.ex08_superdot;
//super. :  내 부모단의
//super() : 내 부모단의 생성자 함수 **** 진짜 많이 쓰인다
public class ChildClass extends ParentClass { // ParentClass - i, method()
	
	private int i = 99;

	// 생성자
	public ChildClass() {
		System.out.println("ChildClass 디폴트 생성자");
	}
	
	// 메소드 - 오버라이드
	@Override
	public void method() {
		System.out.println("ChildClass의 method");
		super.method(); // 나의 method가 아닌 부모클래스의 method
		System.out.println("ChildClass에서 super의 i = " + super.getI()
							+ ", Child 단의 i = " + i);
	} // i 를 private로 해놓았기 때문에 getI()로 받아와야 한다.

	public int getI() {
		return i;
	} // child단의 i임!
	
	

}
