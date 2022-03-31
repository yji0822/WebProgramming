package com.lec.condition;

import java.util.Scanner;

// (실습예제3) 사용자로부터 국어, 영어, 수학 점수를 입력받아 각 과목별 점수가 평균 이상인지 이하인지 출력해 보자
public class Quiz3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("국어 점수 입력: ");
		int kor = sc.nextInt();
		System.out.print("영어 점수 입력: ");
		int eng = sc.nextInt();
		System.out.print("수학 점수 입력: ");
		int math = sc.nextInt();
		double avg = (kor+eng+math)/3.0;
		
		// 국어
		if(kor>avg) {
			System.out.println("국어점수는 평균 이상입니다.");
		}
		else if(kor<avg) {
			System.out.println("국어점수는 평균 이하입니다.");
		}
		else {
			System.out.println("국어점수는 평균입니다.");
		}
		
		// 영어
		if(eng>avg) {
			System.out.println("영어점수는 평균 이상입니다.");
		}
		else if (eng<avg) {
			System.out.println("영어점수는 평균 이하입니다.");
		}
		else {
			System.out.println("영어점수는 평균입니다.");
		}
		
		// 수학
		if (math>avg) {
			System.out.println("수학 점수는 평균 이상입니다.");
		}
		else if (math<avg) {
			System.out.println("수학점수는 평균 이하입니다.");
		}
		else {
			System.out.println("수학 점수는 평균 입니다.");
		}
		
		sc.close();
		

	}

}
