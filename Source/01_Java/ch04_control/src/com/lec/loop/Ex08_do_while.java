package com.lec.loop;

import java.util.Scanner;

// 실습예제 ⑩ 키보드로부터 짝수를 입력할 때까지 수를 입력받고 짝수를 입력하면 입력된 값을 출력하는 프로그램을 구현하시오
public class Ex08_do_while {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner (System.in);
		
		do {
			System.out.print("짝수를 입력 하세요: ");
			num = sc.nextInt();
		}while(num%2 != 0); // 세미콜론!!! 무조건!!!
		// while이 참일 경우에는 계속 반복문이 돌아가도록..!!!
		System.out.print("입력하신 수는 짝수 " + num + "입니다.");
		
		sc.close();
		// 무한반복문이 돌지 않도록 주의!
	}

}
