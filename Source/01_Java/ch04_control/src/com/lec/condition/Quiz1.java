package com.lec.condition;
// (실습예제1) 수를 입력받아 절대값을 출력하는 프로그램
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("절대값 출력 프로그램");
		System.out.print("숫자를 입력해주세요: ");
		int num = sc.nextInt();
		
		if (num > 0) {
			System.out.println(num +"의 절대값은 " + num);
		}
		else if (num < 0) {
			System.out.println(num + "의 절대값은 " + -num);		
		}
		else {
			System.out.println("입력하신 숫자는 0입니다.");
		}
		
		
		sc.close();
		
	}

}
