package com.lec.ex01_parentchild;

public class TestMain {

	public static void main(String[] args) {
		
		ChildClass child = new ChildClass();
		// 1. �θ�Ŭ������ ���� ���� ���� ��ü�� ���� ����, 2. �ڽ�Ŭ������ �޸𸮸� �����Ѵ�.
		child.getMamiName();
		child.getPapaName();
		System.out.println(child.pStr); // �θ�Ŭ������ ������ ȣ�� ����
		System.out.println(child.cStr); // �ڽ�Ŭ������ ���� ȣ�� �翬�� ����
		
	}

}
