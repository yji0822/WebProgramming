package com.lec.ex6_wrapper;

import java.util.Scanner;

// 사용자로부터 정수 문자열("100")을 입력 받아 정수로 수정해서 출력하는 프로그램
// id입력할때 space입력된 것을 지워주는 것
public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수(int num)를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.println("입력하신 정수는 " + num);

		System.out.print("정수(String numStr)를 입력하세요 : ");
		sc.nextLine(); // 초기화
		String numStr = sc.nextLine(); // 다른 문자가 들어올 수도 있다.
		numStr = numStr.trim(); // *** 많이 사용 *** 좌우 스페이스가 제거된다.(numStr에 있는 공백 제거)
//		numStr = numStr.replace("점", ""); - 점이란 단어 하나만 지우게 되는 단점
		numStr = numStr.replaceAll("[a-zA-Z가-힣]", ""); // 문자 제거
		int num1 = Integer.parseInt(numStr); 
		// 스페이스나 빈string값을 넣으면 오류발생 - String을 Integer로 바꿔주는 함수 / 문자열만 입력받았을 경우 오류 발생
		System.out.println("입력하신 문자열은 " + numStr);
		
	}

}
