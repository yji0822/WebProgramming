package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex03_scannerClose {

	public static void main(String[] args) {
		// BookLib 객체 만들어서 사용자에게 대출 or 반납
		Scanner scMain = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scMain.nextLine();
		System.out.println("입력하신 이름은 " + name + "입니다.");
		
		nickName();
		
		System.out.print("나이 : ");
		int age = scMain.nextInt();
		System.out.println("입력하신 나이는 " + age + "입니다.");
		
		
		scMain.close();
		
	}
	
	private static void nickName() { // 사용자로부터 별명을 받아 출력하는 메소드
	// static에서 호출한 함수는 반드시 static이어야 한다.
		Scanner scNickName = new Scanner(System.in);
		System.out.print("별명 : ");
		System.out.println("입력하신 별명은 " + scNickName.nextLine());
		// 같은 버퍼를 사용하고 있기 때문에 또 초기화를 안해주어도 된다.
//		scNickName.close();
		
	}
	
}
