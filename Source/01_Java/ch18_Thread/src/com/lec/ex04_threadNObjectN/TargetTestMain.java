package com.lec.ex04_threadNObjectN;

public class TargetTestMain {

	public static void main(String[] args) {
		
		// 타겟 오브젝트 객체 두개 생성
		TargetEx target1 = new TargetEx();
		TargetEx target2 = new TargetEx();
		Thread threadA = new Thread(target1, "A");
		Thread threadB = new Thread(target2, "B");
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {}
		System.out.println("target1의 num: " + target1.getNum());
		System.out.println("target1의 num: " + target2.getNum());
		System.out.println("main method finish");
		
		// thread는 2개 target은 하나
		// threadB도 증가하는 것과 같은 출력결과
	}

}
