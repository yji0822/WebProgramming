package com.lec.ex01_runnable;
// 두개의 Targets을 동시에 돌릴 것 - 내부적으로 run을 수행해야하기 때문에 객체생성
public class TargetTestMain {

	public static void main(String[] args) {
		Runnable target1 = new TargetEx01();
		Runnable target2 = new TargetEx02(); 
//		TargetEx02 target2 = new TargetEx02(); 
		
		// 이건 순차적으로 실행하는 것임
//		target1.run();
//		target2.run();
		
		// A라는 이름의 thread 객체 생성 - target1.run() 수행
		Thread threadA = new Thread(target1, "A"); // 실행 전
		// B라는 이름의 스레드 객체 생성 - target2.run() 수행
		Thread threadB = new Thread(target2, "B");
		// go~shoot을 해주어야지 동시에 실행이 된다.
		// 실행 가능한 상태로 변환한 것.
		threadA.start();
		threadB.start();
		for(int i=0; i<10; i++) {
			System.out.println("★나는 메인 thread ★ "+ Thread.currentThread().getName() + i); 
			// currentThread().getName() : 현재 스레드의 이름을 가지고 옴
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}

	}

}
