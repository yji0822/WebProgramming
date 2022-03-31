package com.lec.ex;

import java.util.Scanner;

// 5. 사용자로부터 수를 입력 받아 절대값을 출력하는 로직을 구현하시오 (단, 매개변수를 받아 절대값을 리턴하는 함수(=메소드)를 이용합니다.
public class Quiz02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력: ");
		int user = sc.nextInt();
		System.out.println(user + "의 절대값: " + abs(user));
		
		sc.close();
			
	}
	
	private static int abs(int user) {
		/* if (user>=0) {
			return user;
		}
		else {
			return -user;
		} */
		return user>=0 ? user : -user;

	}
	
	

}
