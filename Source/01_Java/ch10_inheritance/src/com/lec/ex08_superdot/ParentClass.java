package com.lec.ex08_superdot;
// super. :  내 부모단의
// super() : 내 부모단의 생성자 함수 **** 진짜 많이 쓰인다
public class ParentClass {
	
	private int i = 20;
	
	// 생성자
	public ParentClass() {
		System.out.println("ParentClass default 생성자");
	}
	
	// method
	public void method() {
		System.out.println("ParentClass의 method, super 단의 i는 " + i);
	}
	
	// getter
	public int getI() {
		return i;
	}


}
