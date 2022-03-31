package com.lec.ex07_override;

public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("�Ű����� ���� ChildClass ������");
	}
	public ChildClass(int i) {
		System.out.println("�Ű����� �ִ� ChildClass ������");
	}
	
	// �޼ҵ�
	public void method3() {
		System.out.println("ChildClass�� method3() �Լ�");
	}
	
	// �������̵� - �Լ��� ������
	@Override
	public void method1() {
		System.out.println("ChildClass�� method1()�Լ�");
	}
	// ������������ ������ �ٲ� ���� �ִ�. private > public �̷� ������
	
	@Override
	public boolean equals(Object obj) {
		return true; // ������ true�� ����ϴ� ������ ������ �������̵� �޼ҵ�
	}
	
}
