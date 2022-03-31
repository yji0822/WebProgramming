package com.lec.homework;

public class Ex {

	public static void main(String[] args) {
//		국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 
//		총점, 평균 출력하는 프로그램 구현하시오. 
//		(com.lec.homework 패키지 내에 작성한 Ex.java를 
//				yisy0703@naver.com으로 메일발송 하시오.)
		
		int kor = 100;
		int eng = 97;
		int math = 96; // 알아보기 쉬운 것이 가독성이 높은 것이다.
		System.out.println("국어점수: " + kor + "\t 영어점수: " + eng + "\t 수학점수: " + math);
		System.out.printf("국어점수는 %d점, 영어점수는 %d점, 수학점수는 %d점입니다. \n", kor, eng, math);
		
		int tot = kor+eng+math;
		double avg = tot / 3.0; // 실수는 무조건 더블!
		
		System.out.println("총점: " + tot +" 점");
		System.out.println("평균: " + avg + " 점");
		
		System.out.printf("총점은 %d점, 평균은 %.f점 입니다.", tot,avg);
		
		/*
		double 국어 = 99.9;
		double 수학 = 97.8;
		double 영어 = 96.6;
		
		double tot1 = 국어 + 수학 + 영어;
		double avg1 = tot / 3.0;
		System.out.println("총점: " + tot1 +" 점");
		System.out.println("평균: " + avg1 + " 점");
		// 실수형 덧셈은 왜 이렇게 나오는지..!
		// 소수점 몇자리까지 나올 수 있게 하는 방법 - 이건 나중에 다른 함수 이용해서.
		 */

		

	}

}
