package com.lec.ex07_friend;

public class TestMain {

	public static void main(String[] args) {
		
		Friend f1 = new Friend(); //�Ű����� ���� ������ �Լ�
		System.out.println(f1.infoString()); //	[�̸�] null, [��ȭ] null
		
		System.out.println();
		Friend f2 = new Friend("ȫ�浿");
		// �Ű����� ���� ������ �Լ�
		// �Ű����� �ϳ�¥�� ������ �Լ�
		System.out.println(f2.infoString());
		// [�̸�] ȫ�浿, [��ȭ] null
		
		System.out.println();
		Friend f3 = new Friend("ȫ���", "010-000-1234");
		System.out.println(f3.infoString());
		
	}

}
