package com.lec.ex03_threadNObject1;

public class TargetTestMain2 {

	public static void main(String[] args) {
		
		// Ÿ�� ������Ʈ ��ü �ϳ� ����
		Runnable target = new TargetEx2();
		Thread threadA = new Thread(target, "A");
		Thread threadB = new Thread(target, "B");
		threadA.start();
		threadB.start();
		System.out.println("main method finish");
		
		// thread�� 2�� target�� �ϳ�
		// threadB�� �����ϴ� �Ͱ� ���� ��°��
	}

}
