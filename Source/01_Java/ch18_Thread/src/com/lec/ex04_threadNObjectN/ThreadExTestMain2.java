package com.lec.ex04_threadNObjectN;

public class ThreadExTestMain2 {

	public static void main(String[] args) {
		
		ThreadEx2 threadA = new ThreadEx2("A");
		ThreadEx2 threadB = new ThreadEx2("B");
		
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {}
		
		System.out.println("* AÀÇ Num: " + threadA.getNum());
		System.out.println("* BÀÇ Num: " + threadB.getNum());
		
	} // main

}
