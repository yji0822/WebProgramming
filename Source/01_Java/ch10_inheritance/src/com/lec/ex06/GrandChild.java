package com.lec.ex06;

public class GrandChild extends Child1 {
	int gc;
	
	public GrandChild() {
		System.out.println("GrandChild�� ��ü ����");
	}
	public GrandChild(int gc) {
		System.out.println("GrandChild�� ��ü ����(�Ű�����)");
		this.gc = gc;
	}

}
