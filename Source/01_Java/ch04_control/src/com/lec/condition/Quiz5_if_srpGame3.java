package com.lec.condition;

import java.util.Scanner;

public class Quiz5_if_srpGame3 {

	public static void main(String[] args) {
		// 가위바위보 연습
		
		Scanner sc = new Scanner (System.in);
		
		int you;
		int computer = (int)(Math.random()*3); // 3개를 랜덤으로 출력할 것
		
		System.out.print("가위는 0, 바위는 1, 보는 2를  입력해주세요 : ");
		you = sc.nextInt();
		if (you==0) {
			System.out.println("you 가위 \t");
		}
		else if (you == 1) {
			System.out.println("you 바위 \t");
		}
		else if (you == 2) {
			System.out.println("you 보 \t");
		}
		else {
			System.out.println("잘못 입력했습니다.");
			you = 3;
		}
		
		if(you != 3) { // 승패 출력
			// 삼항연산자 ** 연습!!!
			String msg = (computer == 0) ? "com 가위" : (computer == 1) ? "com 바위" : "com 보";
			System.out.println(msg);
		}

	}

}
