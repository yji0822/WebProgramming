package com.lec.ex4_object;

public class Ex02_PersonTestMain {

	public static void main(String[] args) {
		
		Person p1 = new Person(9512121021021L); // long���̱� ������ L�� �� �ٿ��ش�.
		Person p2 = new Person(9512121021021L);
		Person p3 = null;
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		if(p1.equals(p2)) {
			System.out.println("p1�� p2�� ���� ���");
		} else {
			System.out.println("p1�� p2�� �ٸ� ���");
		} // �ٸ� ��� ��� - equals �������̵�� ���� ��� ����� �ȴ�!
		
		System.out.println(p1.equals(p3)? "p1�̶� p3�� ���� ���" : "p1�̶� p3�� "
				+ "�ٸ� ���");
		
		if(p1==p2) { // �ּҰ� ���İ� ����� ��
			System.out.println("p1�� p2�� ���� �ּ�");
		} else {
			System.out.println("p1�� p2�� �ٸ� �ּ�");
		} // �ٸ� �ּ� ���

	}

}
