package com.lec.ex2;

public class TestMain {

	public static void main(String[] args) {
		
		SuperClass obj = new ChildClass(); // ������ Ÿ�����δ� ���� �� ����
		obj.method1();
		obj.method2();
		
//		SuperClass s = new SuperClass() {
//			// �߻�Ŭ������ ������ ���� �� ����
//			public void method1() {
//				System.out.println("main �͸�Ŭ���� ����");
//			} // ���Ƿ� �ҷ��� �����Ű�� method1
//		}; // SuperClass�� ������ �͸��� Ŭ����
//		s.method1();
		
		
	}

}
