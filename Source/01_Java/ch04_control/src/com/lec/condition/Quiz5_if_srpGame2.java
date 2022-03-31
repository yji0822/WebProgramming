package com.lec.condition;

import java.util.Scanner;

public class Quiz5_if_srpGame2 {

	public static void main(String[] args) {
		// 컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오. 
		// 단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 
		// 보를 선택하고자 할 때는 2를 입력하여 게임을 진행합니다.
		
		Scanner sc = new Scanner (System.in);
		int you;
		int computer = (int)(Math.random()*3);
		
		System.out.print("가위(0) 바위(1) 보(2) 중 하나를 선택하세요: ");
		you = sc.nextInt(); // 정수를 입력 받음
		if (you == 0) {
			System.out.print("you 가위 \t");
		} else if (you == 1) {
			System.out.print("you 바위 \t");
		} else if (you == 2) {
			System.out.print("you 보 \t");
		} else {
			System.out.println("잘못 입력했습니다.");
			you=3; // 프로그램을 끝내기 위해서 3을 넣어준다.
		} // if - you출력
		
		if(you != 3) { // 컴퓨터가 낸 것과 승패 출력
			// 삼항연산자 사용 *** 생각보다 많이 사용한다.
			String msg = (computer == 0)? "com 가위 " : (computer==1)? "com 바위" : "com 보";
			System.out.println(msg);
			// 경우의 수 3가지 : 졌다, 이겼다. 비겼다
			if ((you+1)%3 == computer) {
				System.out.println("COM WIN");
			} else if (you == computer) {
				System.out.println("DRAW");
			} else {
				System.out.println("YOU WIN");
			}
		} // if - 승패출력
		
		sc.close();

	} // main

} // class
