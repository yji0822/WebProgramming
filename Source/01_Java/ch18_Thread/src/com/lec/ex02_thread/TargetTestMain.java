package com.lec.ex02_thread;

public class TargetTestMain {

	public static void main(String[] args) {
		
		TargetEx01 threadA = new TargetEx01("A"); // 생성자에서 넣어주었기 때문에 괄호에 데이터 초기화 가능
		TargetEx02 threadB = new TargetEx02();
		threadB.setName("B"); // getName으로 지정해주어야 한다.
		
		threadA.start();
		threadB.start();
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("main method finish");
		
	}

}
