package com.lec.ex08_superdot;
// ParentClass - i (private), method(), getI()
// ChildClass - i(private), method(), getI();
public class TestMain {

	public static void main(String[] args) {
		
		ChildClass child = new ChildClass();
//		ParentClass default ������
//		ChildClass ����Ʈ ������
		// �����Լ������� super ������! main �Լ������� superclass�� ã�� ����
		System.out.println(child.getI()); // 99
		child.method();
//		ChildClass�� method
//		ParentClass�� method, super ���� i�� 20
//		ChildClass���� super�� i = 20, Child ���� i = 99
		

	}

}
