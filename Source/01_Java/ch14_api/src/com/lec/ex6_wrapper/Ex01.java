package com.lec.ex6_wrapper;

import com.lec.ex4_object.Dept;
import com.lec.ex4_object.Sawon;

public class Ex01 {

	public static void main(String[] args) {

		int i = 10;
		int j = 10;
		int sum = i+j;
		System.out.println("���� " + sum); 
		System.out.println(i==j ? "�� int�� ����." : "�� int�� �ٸ���");
		
		Integer iObj = new Integer(10); // wrapper class
		Integer jObj = 10; // new Integer(10); �Ȱ��� ��
		sum = iObj.intValue() + jObj.intValue(); // �ȿ� �ִ� �������� �������� �Լ�
		System.out.println("���� " + sum);
		System.out.println(iObj.equals(jObj) ? "�� wrapper��ü ���� ����" : "�� wrapper ��ü ���� �ٸ���");
		System.out.println(iObj == jObj ? "���� �ּ�" : "�ٸ� �ּ�");
		
		Sawon s = new Sawon("a01", "ȫ�浿", Dept.COMPUTER);
		if(s.equals(new Integer(10))) {
			System.out.println("����");
		} else {
			System.out.println("�ٸ���");
		}
		
	}

}
