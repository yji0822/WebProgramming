package com.lec.ex6_wrapper;

public class Ex02 {

	public static void main(String[] args) {

		double i = 10.1;
		double j = 10.1;
		double sum = i+j;
		System.out.println("���� " + sum); 
		System.out.println(i==j ? "�� double�� ����." : "�� double�� �ٸ���");
		
		Double iObj = new Double(10.1); // wrapper class
		Double jObj = 10.1; // new Double(10.1); �Ȱ��� ��
		sum = iObj + jObj; // �˾Ƽ� �ڵ����� �����´�. sum = iObj.intValue() + jObj.intValue(); // �ȿ� �ִ� �������� �������� �Լ�
		System.out.println("���� " + sum);
		System.out.println(iObj.equals(j) ? "�� wrapper��ü ���� ����" : "�� wrapper ��ü ���� �ٸ���"); // ���ʵ�����Ÿ���� �ڵ����� �����Ǿ ���� ������ �׳� �־��־ �ȴ�.**
		System.out.println(iObj == jObj ? "���� �ּ�" : "�ٸ� �ּ�");
		
		
	}

}
