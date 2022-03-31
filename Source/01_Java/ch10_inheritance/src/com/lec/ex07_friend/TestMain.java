package com.lec.ex07_friend;

public class TestMain {

	public static void main(String[] args) {
		
		Friend f1 = new Friend(); //매개변수 없는 생성자 함수
		System.out.println(f1.infoString()); //	[이름] null, [전화] null
		
		System.out.println();
		Friend f2 = new Friend("홍길동");
		// 매개변수 없는 생성자 함수
		// 매개변수 하나짜리 생성자 함수
		System.out.println(f2.infoString());
		// [이름] 홍길동, [전화] null
		
		System.out.println();
		Friend f3 = new Friend("홍길순", "010-000-1234");
		System.out.println(f3.infoString());
		
	}

}
