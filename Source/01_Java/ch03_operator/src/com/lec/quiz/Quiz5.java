package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {

	public static void main(String[] args) {
		//(Quiz 5) 국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 
		// 총점, 평균(소수점2자리까지) 출력하는 프로그램을 구현 하시오
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 점수 입력: ");
		int kor = scanner.nextInt();
		System.out.print("영어 점수 입력: ");
		int eng = scanner.nextInt();
		System.out.print("수학 점수 입력: ");
		int math  = scanner.nextInt();
		
		int sum = kor+eng+math;
		double avg = (double)sum/3.0;
		
		System.out.printf("총점: %d점, 평균: %.2f점 ", sum,avg); 
		// %.2f 소수점 두번째 자리에서 반올림
		
		scanner.close();
		

	}

}
