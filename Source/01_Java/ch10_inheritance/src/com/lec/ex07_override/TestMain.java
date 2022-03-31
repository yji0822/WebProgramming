package com.lec.ex07_override;

public class TestMain {

	public static void main(String[] args) {
		
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass();
		
		if(pObj1.equals(pObj2)) { // ��ü�� ��ü�� ���� ��쿡�� .equals()�Լ��� ����Ѵ�.
			System.out.println("�� ��ü�� ����.");
		} else {
			System.out.println("�� ��ü�� �ٸ���.");
		}
		// ������ : �� ��ü�� �ٸ���.
		
		System.out.println();
		ChildClass cObj = new ChildClass(2);
		if(cObj.equals(pObj2)) {
			System.out.println("�������̵�. ������ TRUE ���");
		}
		
		System.out.println();
		pObj1.method1();
		pObj1.method2();
//		pObj1.method3(); - ParentClass���� �޼ҵ尡 �����Ƿ� ���� �Ұ�
		
		System.out.println();
		cObj.method1(); // ChildClass�� method1 - �������̵� �Լ�
		cObj.method2(); // ParentClass�� method2
		cObj.method3(); // ChildClass�� method3
		
		System.out.println();
		ParentClass cObj1 = new ChildClass(2);
//		cObj1.method3(); - ParentClass���� ���� �޼ҵ�
		cObj1.method1(); // ChildClass�� method1 ��� - �������̵� �Լ�
		cObj1.method2(); // ParentClass�� method2 ���
		// ����ȯ - ���������� �ٲ� ���̹Ƿ� if���� ����Ͽ� �������ش�.
		if(cObj1 instanceof ChildClass) {
			((ChildClass)cObj1).method3();
			System.out.println("�������̵� ����ȯ ����");
		} else {
			System.out.println("����ȯ �Ұ�");
		}
		
		
		
		


	}

}
