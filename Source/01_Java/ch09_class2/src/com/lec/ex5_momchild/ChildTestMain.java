package com.lec.ex5_momchild;

public class ChildTestMain {

	public static void main(String[] args) {
		
		Child child1 = new Child("ù° �ʸ���");
		Child child2 = new Child("��° ������");
		Child child3 = new Child("��° �ʼ���");
		
		child1.takeMoney(1000);
		child2.takeMoney(1000);
		child3.takeMoney(1000);
		// ���� �������� ��� �ʱ�ȭ�� �Ǵ� ���� �߻� - ���� �ٸ� ������ �������� ���� ���������� �ȴ�. MomPouch�� �Ϲ� ������ �׷���.
		// �ذ��� : ������ �ϳ��� ����� �־�� �Ѵ�! - ������ static ���� ����� �־�� �Ѵ�.
		
		System.out.println(Child.momPouch.money); // Ŭ���� �̸��� ���ؼ� �׼��� �ϴ� ���� �Ϲ���.
		System.out.println(child1.momPouch.money); 
		System.out.println(child2.momPouch.money); 
		System.out.println(child3.momPouch.money); 
		
	}

}

// static - ����. final Ȯ���� ���ؼ� ��� ���� �Ѵ�.