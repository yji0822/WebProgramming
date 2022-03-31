package com.lec.ex6_member;

public class MemberTestMain {

	public static void main(String[] args) {
		
		Member member = new Member("aaa", "xxx", "홍길동", "hong@company.com",
				"서울 강남구", "2000-01-01", 'M');
		System.out.println(member.infoString());
		
//		PersonInfo[] person = new PersonInfo[2];
//		person [0] = new PersonInfo("홍길동", 20, 'm');
//		person [1] = new PersonInfo("홍길순", 19, 'f');

		System.out.println("< 배열을 이용한 출력 >");
		
		Member[] m = new Member[2];
		m[0] = new Member("aaa", "xxx", "홍길동", "hong@company.com",
				"서울 강남구", "2000-01-01", 'M');
		m[1] = new Member("bbb", "zzz", "가나다", "abc@company.com",
				"서울 용산구", "1995-08-22", 'F');
		
		for(Member mem : m) {
			System.out.println(mem.infoString());
		} // 확장 for문 
		

	}

}
