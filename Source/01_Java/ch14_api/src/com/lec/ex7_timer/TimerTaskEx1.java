package com.lec.ex7_timer;

import java.util.TimerTask;

public class TimerTaskEx1 extends TimerTask {

	// TimerTask가 추상메소드이기 때문에 오버라이드 함수를 불러와야 한다.
	@Override
	public void run() {
		
		System.out.println("@@@ 작업1 : 2초 후에 한번 수행될 예정인 작업(TimerTask) @@@");
		
	}

}
