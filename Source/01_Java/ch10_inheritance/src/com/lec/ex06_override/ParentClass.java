package com.lec.ex06_override;

public class ParentClass {

	// ������ overloading = �Լ� �ߺ� ���� (�Ű������� ���� Ÿ���� �޸��ϴ� ��)
	public ParentClass() {
		System.out.println("�Ű����� ���� ParentClass ������");
	}
	public ParentClass(int i) {
		System.out.println("�Ű����� �ִ� ParentClass ������");
	}
	
	// method
	public void method1() {
		System.out.println("ParentClass�� method1() �Լ�");
	}
	public void method2() {
		System.out.println("ParentClass�� method2() �Լ�");
	}
	
	// �����Ͱ� �����Ƿ� getter&setter �Ұ�
	
}
