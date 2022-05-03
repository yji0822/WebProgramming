package com.lec.ex04_threadNObjectN;

public class TargetEx implements Runnable {

	private int num = 0;
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			if(Thread.currentThread().getName().equals("A")) { // �Է��� thread�̸��� A�� ���
				System.out.println("~ A Thread ���� �� ~");
				num++;
			} 
			System.out.println(Thread.currentThread().getName() + "�� num = " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		} // for
	} // run

	public int getNum() { // ���ο��� �ٸ��� ���̴� �� Ȯ���ϱ� ���ؼ�
		return num;
	}
	
	

}
