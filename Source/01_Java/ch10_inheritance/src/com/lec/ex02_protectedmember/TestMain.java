package com.lec.ex02_protectedmember;

public class TestMain {

	public static void main(String[] args) {
		Child child = new Child(1, 2);
		/* ���
		 * �Ű����� ���� �� SuperIJ ������ �Լ�
		 * �Ű����� �ִ� Child ������
		 */
		System.out.println("child�� i: " + child.getI()); 
		// child.getI(): ���� ��Ű���� ��� ������ ��.
		System.out.println("child�� j: " + child.getJ());
		child.setI(10);
		child.setJ(30);
		child.sum();
		
		// �θ� Ŭ���������� ������ ����Ʈ �����ڰ� �־�� �Ѵ�!
		// �� �����ڰ� �ִ°� ȣ���� �ȵǴ���..!
		

	}

}
