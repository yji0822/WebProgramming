package com.lec.ex01_runnable;
// 반갑습니다 10번 작업
public class TargetEx02 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(i + "번째 반갑습니다.");
			try { // 대기에서 못빠져나올 수 있기 때문에 
				Thread.sleep(500); // Tread안에 있는 static method
			} catch (InterruptedException e) {}
		}
		
	}

}
