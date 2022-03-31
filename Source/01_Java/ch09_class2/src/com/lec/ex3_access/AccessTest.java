package com.lec.ex3_access;

public class AccessTest {
	// ������
	private int privateMember; // ���� Ŭ���� ��������
	int defaultMember;		   // ����Ʈ: ���� ��Ű��������
	protected int protectedMember; // ���� ��Ű���� ��ӹ��� ���� Ŭ����������
	public int publicMember; // �ƹ�������
	
	// �޼ҵ�
	private void privateMethod() {
		System.out.println("private method");
	}
	void defaultMethod() {
		System.out.println("default method");
	}
	protected void protectedMethod() {
		System.out.println("protected method");
	}
	public void publicMethod() {
		System.out.println("public method");
	}

}
