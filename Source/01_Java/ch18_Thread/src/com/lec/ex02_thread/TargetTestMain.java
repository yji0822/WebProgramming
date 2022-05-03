package com.lec.ex02_thread;

public class TargetTestMain {

	public static void main(String[] args) {
		
		TargetEx01 threadA = new TargetEx01("A"); // �����ڿ��� �־��־��� ������ ��ȣ�� ������ �ʱ�ȭ ����
		TargetEx02 threadB = new TargetEx02();
		threadB.setName("B"); // getName���� �������־�� �Ѵ�.
		
		threadA.start();
		threadB.start();
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("main method finish");
		
	}

}
