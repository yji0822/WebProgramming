package com.lec.ex;

// import java.util.Scanner;

public class RectTestMain {

	public static void main(String[] args) {
		// Rect();
		Rect r1 = new Rect(); // 메모리에 안착시키는 역할 new
		r1.setWidth(10);
		r1.setHeight(5);
		System.out.println("r1의 넓이는 " + r1.area());
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("r1 가로: ");
//		r1.setWidth(sc.nextInt());
//		System.out.print("r1 세로: ");
//		r1.setHeight(sc.nextInt());
//		System.out.println("r1의 넓이: " + r1.area());
		
		Rect r2 = new Rect();
		System.out.println("r2의 넓이는 " + r2.area());
		System.out.println("r2의 넓이는 " + r2.area());
		// ctrl+alt+방향키 - 윗장 복사
		
		
//		sc.close();
	}
	
}
