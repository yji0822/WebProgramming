package com.lec.condition;

import java.util.Scanner;

public class Quiz5_if_srpGame {

	public static void main(String[] args) {
		// 컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오. 
		// 단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 
		// 보를 선택하고자 할 때는 2를 입력하여 게임을 진행합니다.
		
		Scanner sc = new Scanner (System.in);
		int you;
		int computer = (int)(Math.random()*3);
		// 0 <= Math.random() < 1 
		// 0 <= Math.random()*3 < 3 -3개의 숫자를 뽑는다는 의미
		// 0 <= (int) Math.random() -0,1,2 
		// 0 <= ((int) Math.random()*3) -완성본
		System.out.print("가위(0) 바위(1) 보(2) 중 하나를 선택하세요: ");
		you = sc.nextInt(); // 정수를 입력 받음
		if (you == 0) {
			System.out.print("you 가위 \t");
		}
		else if (you == 1) {
			System.out.print("you 바위 \t");
		}
		else if (you == 2) {
			System.out.print("you 보 \t");
		}
		else {
			System.out.println("잘못 입력했습니다.");
			you=3; // 프로그램을 끝내기 위해서 3을 넣어준다.
		}
		
		if(you != 3) { // 컴퓨터가 낸 것과 승패 출력
			// 삼항연산자 사용 *** 생각보다 많이 사용한다.
			String msg = (computer == 0)? "com 가위 " : (computer==1)? "com 바위" : "com 보";
			System.out.println(msg);
			if(you == 0) {
				if (computer == 0) {
				System.out.println("DRAW");
				}
				else if (computer == 1) {
					System.out.println("COM WIN");
				}
				else {
					System.out.println("YOU WIN");
				}
			}
			else if(you == 1) {
				if (computer == 0) {
					System.out.println("YOU WIN");
					}
					else if (computer == 1) {
						System.out.println("DRAW");
					}
					else {
						System.out.println("COM WIN");
					}
			}
			else if(you == 2) {
				if (computer == 0) {
					System.out.println("COM WIN");
					} // if
					else if (computer == 1) {
						System.out.println("YOU WIN");
					} // else if
					else {
						System.out.println("DRAW");
					} // else
			} // else if
		} // if
		
		sc.close();

	}

}
