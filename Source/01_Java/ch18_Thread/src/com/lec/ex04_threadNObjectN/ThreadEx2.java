package com.lec.ex04_threadNObjectN;
// ThreadEx threadA = new ThreadEx("A);
public class ThreadEx2 extends Thread {
	
	private int num = 0;
	
	// ������
	public ThreadEx2(String name) {
		super(name);
	}
	
	@Override
	public synchronized void run() {
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
	
	// getter
	public int getNum() {
		return num;
	}
	
	
	
}
