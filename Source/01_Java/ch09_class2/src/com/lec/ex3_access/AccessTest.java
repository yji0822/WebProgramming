package com.lec.ex3_access;

public class AccessTest {
	// 데이터
	private int privateMember; // 같은 클래스 내에서만
	int defaultMember;		   // 디폴트: 같은 패키지에서만
	protected int protectedMember; // 같은 패키지나 상속받은 하위 클래스에서만
	public int publicMember; // 아무데서나
	
	// 메소드
	private void privateMethod() {
		System.out.println("private method");
	}
	void defaultMethod() {
		System.out.println("default method");
	}
	protected void protectedMethod() {
		System.out.println("protected method");
	}
	public void publicMethod() {
		System.out.println("public method");
	}

}
