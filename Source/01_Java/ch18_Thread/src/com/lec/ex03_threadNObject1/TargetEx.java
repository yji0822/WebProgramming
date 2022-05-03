package com.lec.ex03_threadNObject1;

public class TargetEx implements Runnable {

	private int num = 0;
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			if(Thread.currentThread().getName().equals("A")) { // 입력한 thread이름이 A일 경우
				System.out.println("~ A Thread 수행 중 ~");
				num++;
			} 
			System.out.println(Thread.currentThread().getName() + "의 num = " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		} // for
	} // run

}
