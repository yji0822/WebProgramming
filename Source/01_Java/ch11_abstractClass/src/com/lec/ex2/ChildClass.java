package com.lec.ex2;
// method1(�߻�޼ҵ�), method2(�Ϲݸ޼ҵ�) ��� ���
public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("ChildClass�� method1 - �߻� �޼ҵ�� �������̵� ��");
	}
	
	// �ʿ信 ���� �������̵� �� �� �ִ� �Ϲ� �޼ҵ� method2()
	@Override
	public void method2() {
		System.out.println("ChildClass�� method2 - �Ϲ� �޼ҵ����� �׳� �������̵� ��");
	}
	
}
