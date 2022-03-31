package com.lec.condition;

import java.util.Scanner;

// 컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오. 
// 단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 
// 보를 선택하고자 할 때는 2를 입력하여 게임을 진행합니다.

// ** 내가 푼거!!!!!!
public class Quiz5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("가위(0) 바위(1) 보(2) 중 한가지를 입력해주세요: ");
		int user = sc.nextInt();
		int com = (int) (Math.random()*3);
		// 숫자 세개를 뽑는데 시작 숫자가 0!
		
		if (user == 2) { //보
			if(com == 0) {
				System.out.println(com);
				System.out.println("YOU LOSE");
			}
			else if (com == 1) {
				System.out.println(com);
				System.out.println("YOU WIN");
			}
			else {
				System.out.println(com);
				System.out.println("비김!");
			}
		}
		else if (user == 1) { //바위
			if(com == 0) {
				System.out.println(com);
				System.out.println("YOU WIN");
			}
			else if (com == 2) {
				System.out.println(com);
				System.out.println("YOU LOSE");
			}
			else {
				System.out.println(com);
				System.out.println("비김!");
			}			
		}
		else { // 가위
			if(com == 1) {
				System.out.println(com);
				System.out.println("YOU LOSE");
			}
			else if (com == 2) {
				System.out.println(com);
				System.out.println("YOU WIN");
			}
			else {
				System.out.println(com);
				System.out.println("비김!");
			}		
		}
		
		sc.close();

	}

}
