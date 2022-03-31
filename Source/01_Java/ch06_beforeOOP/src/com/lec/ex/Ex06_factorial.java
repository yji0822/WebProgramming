package com.lec.ex;
import java.util.Scanner;
// 재귀적호출 : 사용자로부터 수를 입력받아 입력받은 수!! 
// 팩토리얼 계산하는 메소드 이용 (입력: 3)! = 3X2X1
public class Ex06_factorial {
	public static void main(String[] args) {

		int su;
		Scanner sc = new Scanner (System.in);
		System.out.println("팩토리얼 계산");
		do {
			System.out.print("숫자를 입력하세요 : ");
			su = sc.nextInt();
		} // 
		while(su<=0);
		long result = factorial(su); // while문
		System.out.println("입력하신 " + su + "! = " + result);
		System.out.printf("입력한 %d! = %d", su, result);
		
		sc.close();
	} // main
	
	private static long factorial(int su) { // su * factorial(su-1)
		// su>1인 경우: su * factorial(su-1)
		if (su==1) { // 1미만인 경우는 main do=while문으로 정리를 해놔서 X
			return 1;
		}
		else return su * factorial(su-1); // 내가 내 자신을 호출
		
	}
	
	
//	private static long factorial(int su) {
//	// 할당된 변수 타입과 동일하게 리턴타입 정해주기
//		int result = 1;
//		// 일반for문 - 재귀적 함수를 사용x
//		for(int i=su; i>=1; i--) {
//			result *= i;
//		}
//		return result;
//	}

}
