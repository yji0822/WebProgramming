package com.lec.ex09_super;

public class TestMain {

	public static void main(String[] args) {
		
		Person papa = new Person(); // name null, char = null - �Ű�����=�Ķ����=���ڰ� ���� Person ������
		papa.setName("�ƺ���");
		papa.setCharacter("�׶���");
		papa.intro(); // �ƺ�����(��) �׶���
		
		System.out.println();
		Person mom = new Person("������", "������"); // �Ű����� 2��¥�� Person ������
		mom.intro(); // ��������(��) ������
		
		System.out.println();
		Baby child1 = new Baby();
//		�Ű�����=�Ķ����=���ڰ� ���� Person ������
//		�Ű����� ���� Baby ������
		child1.setName("�Ʊ��1");
		child1.setCharacter("�Ϳ���");
		child1.intro();
		
		System.out.println();
		Baby child2 = new Baby("�Ʊ��2", "�ʹ��Ϳ���");
		child2.intro();		
//		�������� �� �ư���
//		�Ʊ��2��(��) �ʹ��Ϳ���

	}

}
