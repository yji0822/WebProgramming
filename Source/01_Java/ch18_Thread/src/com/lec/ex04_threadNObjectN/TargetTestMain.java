package com.lec.ex04_threadNObjectN;

public class TargetTestMain {

	public static void main(String[] args) {
		
		// Ÿ�� ������Ʈ ��ü �ΰ� ����
		TargetEx target1 = new TargetEx();
		TargetEx target2 = new TargetEx();
		Thread threadA = new Thread(target1, "A");
		Thread threadB = new Thread(target2, "B");
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {}
		System.out.println("target1�� num: " + target1.getNum());
		System.out.println("target1�� num: " + target2.getNum());
		System.out.println("main method finish");
		
		// thread�� 2�� target�� �ϳ�
		// threadB�� �����ϴ� �Ͱ� ���� ��°��
	}

}
