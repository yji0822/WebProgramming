package com.lec.ex03_threadNObject1;

public class TargetEx2 implements Runnable {

	private int num = 0;
	
	@Override
	public /*synchronized*/ void run() { // run�� synchronized�� ������ �� ��������
		for(int i=0; i<10; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		} // for
	} // run
	
	private synchronized void out() {
		if(Thread.currentThread().getName().equals("A")) { // �Է��� thread�̸��� A�� ���
			System.out.println("~ A Thread ���� �� ~");
			num++;
		} 
		System.out.println(Thread.currentThread().getName() + "�� num = " + num);
	}
	
	

}
