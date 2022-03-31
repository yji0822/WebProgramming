package com.lec.ex4_object;
// Sawon s1 = new Sawon("a01", "홍길동", "전산 or 전산실 or IT or computer..."); // 오늘이 입사일
// Sawon s1 = new Sawon("a02", "신길동", "COMPUTER", 2022, 3, 24); // 3월24일 입사일
public class Ex01_SawonTestMain {

	public static void main(String[] args) {
		
		Sawon s1 = new Sawon("a01", "홍길동", Dept.COMPUTER); // 오늘이 입사일
		Sawon s2 = new Sawon("a02", "신길동", Dept.HUMANRESOURCES, 2022, 3, 24); // 3월24일 입사일
		System.out.println(s1.toString()); 
		System.out.println(s2); // .toString()은 생략 가능하다.
		
		Sawon2 s3 = new Sawon2("c01", "마길동", Dept2.PLANNING, 2022, 3, 10);
		System.out.println(s3);

	}

}
