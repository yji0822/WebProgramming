package com.lec.ex4_access;

import com.lec.ex3_access.AccessTest;

// 다른 패키지에 같은 이름의 AccessTestMain
public class AccessTestMain {

	public static void main(String[] args) {
//		com.lec.ex3_access.AccessTest obj; // 이게 진짜 클래스 이름
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember); // private. 에러.
//		System.out.println(obj.defaultMember); // default. 다른 패키지에 있으므로 에러. 거의 사용 안함
//		System.out.println(obj.protectedMember); // protected. 상속받은 것이 아니기 때문에 에러.
		System.out.println(obj.publicMember);
		
//		obj.privateMethod();
//		obj.defaultMethod();
//		obj.protectedMethod();
		obj.publicMethod();

	}

}
