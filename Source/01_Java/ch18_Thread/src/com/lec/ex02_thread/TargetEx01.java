package com.lec.ex02_thread;
// Thread ta = new Thread(target1, "A");
// Thread t1 = new ThreadEx01("A");
//Thread t1 = new ThreadEx01();
public class TargetEx01 extends Thread { // Thread를 상속받아 사용하는 방법
	
	// 생성자
	public TargetEx01() {}
	public TargetEx01(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println("안녕하세요 : " + i);
			try {
				// 동시에 한다는 느낌 안들어서 현재 작업을 0.5초동안 대기상태로 넣어둠 
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // for
		
	} // run
	
}
