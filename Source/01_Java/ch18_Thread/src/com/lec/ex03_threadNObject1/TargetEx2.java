package com.lec.ex03_threadNObject1;

public class TargetEx2 implements Runnable {

	private int num = 0;
	
	@Override
	public /*synchronized*/ void run() { // run에 synchronized가 있으면 걍 순차실행
		for(int i=0; i<10; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		} // for
	} // run
	
	private synchronized void out() {
		if(Thread.currentThread().getName().equals("A")) { // 입력한 thread이름이 A일 경우
			System.out.println("~ A Thread 수행 중 ~");
			num++;
		} 
		System.out.println(Thread.currentThread().getName() + "의 num = " + num);
	}
	
	

}
