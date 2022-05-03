package com.lec.ex7_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("시작");
		
		Timer timer = new Timer(true); // 디폴트값이 false이기 때문에 true로 해놓지 않으면 timer 상주하고 있다. **
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000); // 2초 후에 task1 수행
		timer.schedule(task2, 1000, 500); // 1초 후 0.5초마다 task2.run() - 5초동안 실행
		// 3초 동안 잠깐 멈춤을 해주어야 프로그램이 끝나기 전에 위의 함수 실행 가능
		Thread.sleep(5000); // 예외처리를 하겠다는 throws 예외 적어주기 - 3초간 멈추라는 의미.
		System.out.println("끝");

	}

}
