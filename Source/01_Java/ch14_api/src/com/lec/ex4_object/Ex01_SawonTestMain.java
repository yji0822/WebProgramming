package com.lec.ex4_object;
// Sawon s1 = new Sawon("a01", "ȫ�浿", "���� or ����� or IT or computer..."); // ������ �Ի���
// Sawon s1 = new Sawon("a02", "�ű浿", "COMPUTER", 2022, 3, 24); // 3��24�� �Ի���
public class Ex01_SawonTestMain {

	public static void main(String[] args) {
		
		Sawon s1 = new Sawon("a01", "ȫ�浿", Dept.COMPUTER); // ������ �Ի���
		Sawon s2 = new Sawon("a02", "�ű浿", Dept.HUMANRESOURCES, 2022, 3, 24); // 3��24�� �Ի���
		System.out.println(s1.toString()); 
		System.out.println(s2); // .toString()�� ���� �����ϴ�.
		
		Sawon2 s3 = new Sawon2("c01", "���浿", Dept2.PLANNING, 2022, 3, 10);
		System.out.println(s3);

	}

}
