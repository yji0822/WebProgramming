package com.lec.ex4_access;

import com.lec.ex3_access.AccessTest;

// �ٸ� ��Ű���� ���� �̸��� AccessTestMain
public class AccessTestMain {

	public static void main(String[] args) {
//		com.lec.ex3_access.AccessTest obj; // �̰� ��¥ Ŭ���� �̸�
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember); // private. ����.
//		System.out.println(obj.defaultMember); // default. �ٸ� ��Ű���� �����Ƿ� ����. ���� ��� ����
//		System.out.println(obj.protectedMember); // protected. ��ӹ��� ���� �ƴϱ� ������ ����.
		System.out.println(obj.publicMember);
		
//		obj.privateMethod();
//		obj.defaultMethod();
//		obj.protectedMethod();
		obj.publicMethod();

	}

}
