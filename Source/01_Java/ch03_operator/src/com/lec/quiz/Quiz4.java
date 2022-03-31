package com.lec.quiz;

import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		//(Quiz4) 나이를 입력받아 입력받은 나이가 65세 이상일 때, 
		// “경로우대” 출력, 아니면 “일반” 출력
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("나이를 입력해주세요: ");
		int age = scanner.nextInt();
		String result = age>=65 ? "경로우대" : "일반";
		System.out.println(result);
		
		scanner.close();
		
		

	}

}
