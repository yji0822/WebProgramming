package com.lec.condition;

import java.util.Scanner;

// (Quiz 4) 가위(0)바위(1)보(2) 중 하나를 내고 낸 것을 출력하세요
public class Quiz4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in); // 객체변수 sc 
		System.out.print("가위(0) 바위(1) 보(2) 중 하나를 선택하세요: ");
		int num = sc.nextInt();
		
		if (num == 0) {
			System.out.println("가위");
		}
		else if (num == 1) {
			System.out.println("바위");
		}
		else if (num == 2) {
			System.out.println("보");
		}
		else {
			System.out.println("잘못 입력했습니다.");
		}
		
		sc.close();		
		
	}
}
