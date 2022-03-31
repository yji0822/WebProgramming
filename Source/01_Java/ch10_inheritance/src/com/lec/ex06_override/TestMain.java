package com.lec.ex06_override;

public class TestMain {
	
	public static void main(String[] args) {
		
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass(1);
		
		if(pObj1.equals(pObj2)) {
			System.out.println("�� ��ü�� ����");
		} // ��ü�� ��ü�� ���� ��쿡�� .equals() �Լ��� ����Ѵ�.
		else {
			System.out.println("�� ��ü�� �ٸ���");
		}
		// ������ : �� ��ü�� �ٸ���
		
		System.out.println();
		ChildClass cObj = new ChildClass(2); 
		if(cObj.equals(pObj2)) {
			System.out.println("override. ������ TRUE ���");
		}
		// ������: override. ������ TRUE ���
		
		System.out.println();
		pObj1.method1();
		pObj1.method2();
//		pObj1.method3(); - �Լ��� ������ ���� �Ұ�
		
		System.out.println();
		cObj.method1(); // ChildClass�� method1
		// �������̵� �Ͽ����Ƿ� pObj1.method1() �� �ٸ� ����� ���
		cObj.method2(); // ParentClass�� method2
		cObj.method3(); // ChildClass�� method3
		
		System.out.println();
		ParentClass cObj1 = new ChildClass(2); // �����Ҷ� ����!
//		cObj1.method3(); - �����߻�
		cObj1.method1(); // ChildClass�� method1 ���
		cObj1.method2(); // ParentClass�� method2���
//		if(ParentClass�� cObj1������ ChildClass������ ��ȯ �����ϴ�?) {
//		((ChildClass)cObj1).method3(); - ��ü�� ��������� ����ȯ �ϴ� ���� ���� ����
//		}
//		�׻� ����ϱ� ���� if������ ��� �Ŀ� ����ȯ�� ���־�� �Ѵ�!!!
//		����ȯ
		System.out.println();
		if(cObj1 instanceof ChildClass) {
			((ChildClass)cObj1).method3();
			System.out.println("�������̵� ����ȯ ����");
		} // if
		else {
			System.out.println("����ȯ �Ұ�");
		}
		
	} // main
} // class
