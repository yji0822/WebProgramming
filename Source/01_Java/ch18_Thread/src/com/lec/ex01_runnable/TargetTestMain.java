package com.lec.ex01_runnable;
// �ΰ��� Targets�� ���ÿ� ���� �� - ���������� run�� �����ؾ��ϱ� ������ ��ü����
public class TargetTestMain {

	public static void main(String[] args) {
		Runnable target1 = new TargetEx01();
		Runnable target2 = new TargetEx02(); 
//		TargetEx02 target2 = new TargetEx02(); 
		
		// �̰� ���������� �����ϴ� ����
//		target1.run();
//		target2.run();
		
		// A��� �̸��� thread ��ü ���� - target1.run() ����
		Thread threadA = new Thread(target1, "A"); // ���� ��
		// B��� �̸��� ������ ��ü ���� - target2.run() ����
		Thread threadB = new Thread(target2, "B");
		// go~shoot�� ���־���� ���ÿ� ������ �ȴ�.
		// ���� ������ ���·� ��ȯ�� ��.
		threadA.start();
		threadB.start();
		for(int i=0; i<10; i++) {
			System.out.println("�ڳ��� ���� thread �� "+ Thread.currentThread().getName() + i); 
			// currentThread().getName() : ���� �������� �̸��� ������ ��
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}

	}

}
