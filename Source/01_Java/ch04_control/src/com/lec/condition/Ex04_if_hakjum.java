package com.lec.condition;
import java.util.Scanner;
// 사용자로부터 점수를 입력받아 학점 출력
public class Ex04_if_hakjum {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("점수를 입력해주세요 : ");
		int score = sc.nextInt();
		
		if(100<=score && score>=90) {
			System.out.println("A");
		}
		else if(score<=80 && score>70) {
			System.out.println("B");
		}
		else if(score<=70 && score>60) {
			System.out.println("C");
		}
		else if(score<=70 && score>60) {
			System.out.println("D");
		}
		else if(score<60 && score>=0) {
			System.out.println("F");
		}
		else {
			System.out.println("유효한 점수가 아닙니다.");
		}
		
		sc.close();
		
		// 파이썬은 삼항연산자로도 가능
	
	}

}
