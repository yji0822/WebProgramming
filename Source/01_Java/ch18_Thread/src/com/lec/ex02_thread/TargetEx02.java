package com.lec.ex02_thread;
// TargetEx02 t2 = new TargetEx02();
public class TargetEx02 extends Thread {
	
	// ������ �ȸ���
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(i + "��° �ݰ����ϴ�.");
			try { // ��⿡�� ���������� �� �ֱ� ������ 
				Thread.sleep(500); // Tread�ȿ� �ִ� static method
			} catch (InterruptedException e) {}
		} // for
	} // run
	
}
