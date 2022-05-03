package com.lec.ex03_threadNObject1;

public class TargetTestMain {

	public static void main(String[] args) {
		
		// 타겟 오브젝트 객체 하나 생성
		Runnable target = new TargetEx();
		Thread threadA = new Thread(target, "A");
		Thread threadB = new Thread(target, "B");
		threadA.start();
		threadB.start();
		System.out.println("main method finish");
		
		// thread는 2개 target은 하나
		// threadB도 증가하는 것과 같은 출력결과
	}

}
