package com.lec.ex6_member;

public class MemberTestMain {

	public static void main(String[] args) {
		
		Member member = new Member("aaa", "xxx", "ȫ�浿", "hong@company.com",
				"���� ������", "2000-01-01", 'M');
		System.out.println(member.infoString());
		
//		PersonInfo[] person = new PersonInfo[2];
//		person [0] = new PersonInfo("ȫ�浿", 20, 'm');
//		person [1] = new PersonInfo("ȫ���", 19, 'f');

		System.out.println("< �迭�� �̿��� ��� >");
		
		Member[] m = new Member[2];
		m[0] = new Member("aaa", "xxx", "ȫ�浿", "hong@company.com",
				"���� ������", "2000-01-01", 'M');
		m[1] = new Member("bbb", "zzz", "������", "abc@company.com",
				"���� ��걸", "1995-08-22", 'F');
		
		for(Member mem : m) {
			System.out.println(mem.infoString());
		} // Ȯ�� for�� 
		

	}

}
