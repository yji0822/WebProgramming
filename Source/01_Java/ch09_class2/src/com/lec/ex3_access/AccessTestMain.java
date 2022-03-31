package com.lec.ex3_access;

public class AccessTestMain {

	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember); // 에러. 출력X
		System.out.println(obj.defaultMember); // 0
		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		
//		obj.privatedMethod(); // 에러. 출력X
		obj.defaultMethod();
		obj.protectedMethod();
		obj.publicMethod();

	}

}
