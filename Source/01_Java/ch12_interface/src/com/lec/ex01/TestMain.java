package com.lec.ex01;

public class TestMain {

	public static void main(String[] args) {
//		InterfaceEx1 ex1 = new InterfaceEx1(); // �������̽� ��ü ���� �Ұ�
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		System.out.println(obj1.CONSTANT_NUM + " / " + obj1.COSNTANT_STRING); // ��ü������ static access ����
		System.out.println(InterfaceEx1.CONSTANT_NUM + " / " + InterfaceEx2.COSNTANT_STRING);
		
		
		InterfaceEx1 obj2 = new InterfaceClass();
		obj2.method1();
//		obj2.method2(); �Ұ�. ����ȯ �ؾ��� InterfaceEx1 Ÿ���̱� ������
		if(obj2 instanceof InterfaceClass) {
			((InterfaceClass) obj2).method2(); // ����ȯ
		} // ��Ȳ�� ���� inteface1�� �����ϰ��ö���. 2�� �����ϰ��ö� ��� ���� �Ѵ�.
//		System.out.println(obj2.CONSTANT_STRING); ����
		
		
		InterfaceEx2 obj3 = new InterfaceClass();
//		obj3.method1(); �Ұ�
		obj3.method2(); // ����
		
		
		
	}

}
