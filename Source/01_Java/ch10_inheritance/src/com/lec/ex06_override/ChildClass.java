package com.lec.ex06_override;
// ParentClass�� method1(), method2() ��� ����
public class ChildClass extends ParentClass {
	
	public ChildClass() {
		System.out.println("�Ű����� ���� ChildClass ������");
	}
	public ChildClass(int i) {
		System.out.println("�Ű����� �ִ� ChildClass ������");
	}
	
	// method
	public void method3() {
		System.out.println("ChildClass�� method3() �Լ�");
	}
	
	// override
	@Override
	public void method1() { // ParentClass�� method1 �������̵�
		System.out.println("ChildClass�� method1() �Լ�");
	} // ������������ ������ �� �ٲ� �� �ִ�. but private > public ������
	// ChildClass���� ���� method1()
	@Override
	public boolean equals(Object obj) { // ObjectŬ������ equals�Լ� override
		return true;
	} // ������ true�� ����ϴ� ������ ����
	
	
	
}
