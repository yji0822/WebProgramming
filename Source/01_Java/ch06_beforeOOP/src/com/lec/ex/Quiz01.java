package com.lec.ex;
import java.util.Scanner;

// 사용자로부터 원하는 단수(2~9) 구구단을 출력하는 프로그램을 구현하시오.
// (단, 단수를 매개변수로 받아 해당 단수의 구구단을 출력하는 부분을 method로 처리한다. 
// 사용자가 2~9 사이의 수가 아닌 수를 입력할 시 2~9사이의 수를 입력할 때까지 계속 입력 받는다.)
// hint : method(int dansu) / do~while문이나 while문 이용

// 다양한 방법으로  선생님이 git에 올리신거 참고하기. 
public class Quiz01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int dansu;
		do {
			System.out.print("출력하고 싶은 단을 입력하세요: ");
			dansu = sc.nextInt();		
		}
		while(dansu<2 || dansu>9);
		method(dansu);
	
		sc.close();
	} // main
	
	private static void method(int dansu) {
			for (int i=1; i<=9; i++) {
				System.out.println(dansu + " X " + i + " = " + (dansu*i));
		} // for	
	} // method

}
