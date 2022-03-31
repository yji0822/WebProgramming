package com.lec.loop;

import java.util.Scanner;

// Homework 4 : 컴퓨터와 가위바위보 게임을 당신이 질 때까지 무한반복하는 게임을 작성하시오.
// (단, 가위대신 0, 바위대신 1, 보대신 2)
// 사용자가 질 때까지 가위바위보 게임을 하는 프로그램 구현
public class Quiz5while {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, computer;
		do {
			computer = (int)(Math.random()*3);
			System.out.print("가위(0), 바위(1), 보(2) 중 하나 내세요 : ");
			you = sc.nextInt();
			if (you == 0) {
				System.out.print("당신은 가위\t");
			} else if (you == 1) {
				System.out.print("당신은 바위\t");
			} else if (you == 2) {
				System.out.print("당신은 보자기\t");
			} else {
				System.out.print("당신은 잘못 냈어요. 바이");
				you = 3; // 끝내기 위한 조건
			} // if - you출력
			
			if (you != 3) { // 컴퓨터가 낸 것과 승패 출력
				String msg = (computer == 0) ? "컴이 가위" : (computer == 1) ? "컴이 바위" : "컴이 보자기";
				System.out.println(msg);
				// 경우의 수가 3가지 : 졌다, 이겼다, 비겼다
				if( (you+1)%3 == computer) {
					System.out.println("당신이 졌어요 ");
					break; //* 졌을 경우 게임 종료
				}else if(you == computer ) {
					System.out.println("비겼다");
				}else {
					System.out.println("당신이 이겼어요 ");
				}// if - 승패 출력
			} // if
		}while(true);
		System.out.println("안녕히 가세요");
	}
}

