package com.lec.condition;

import java.util.Scanner;

// (Quiz 6) 현재 몇월인지를 키보드로부터 입력받아 계월을 출력하는 프로그램을 구현하세요
// Api 이용 / 현재 몇월인지 시스템에서 불러와서 계월을 출력할 수 있다! ***
public class Quiz6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("월을 입력하세요: ");
		int month = sc.nextInt();
		
		switch(month) {
		case 12: case 1: case 2:
			System.out.println("Winter, 겨울");
			break;
		case 3: case 4: case 5:
			System.out.println("Spring, 봄");
			break;
		case 6: case 7: case 8:
			System.out.println("Summer, 여름");
			break;
		case 9: case 10: case 11:
			System.out.println("Fall, 가을");
			break;
		default:
			System.out.println("떼끼");
		}
		
		sc.close();

	}

}
