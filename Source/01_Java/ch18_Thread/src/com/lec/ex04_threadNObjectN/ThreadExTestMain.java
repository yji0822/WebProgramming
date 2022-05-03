package com.lec.ex04_threadNObjectN;

public class ThreadExTestMain {

	public static void main(String[] args) {
		
		ThreadEx threadA = new ThreadEx("A");
		ThreadEx threadB = new ThreadEx("B");
		
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {}
		
		System.out.println("A�� Num: " + threadA.getNum());
		System.out.println("B�� Num: " + threadB.getNum());
		
	} // main

}
