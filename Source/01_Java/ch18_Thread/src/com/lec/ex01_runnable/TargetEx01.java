package com.lec.ex01_runnable;
// 안녕하세요 10번 출력하는 target
// 안녕하세요~~~~ 반갑~~~ or 안녕반갑~안녕반갑~ 이건 JVM이 할 역할
public class TargetEx01 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("안녕하세요 : " + i);
			try {
				// 동시에 한다는 느낌 안들어서 현재 작업을 0.5초동안 대기상태로 넣어둠 
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

}
