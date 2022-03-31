package com.lec.ex1_string;

import java.util.Scanner;

// 주민번호를 입력받아 여자인지 남자인지 출력 예제> 
// 주민번호는 “920225-2012121”형식으로 입력받는다

public class quiz01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민번호를 입력해주세요 (입력방식: 950822-123456): ");
		String jumin = sc.next();
		
		if((jumin.charAt(7) == '1') || (jumin.charAt(7) == '3') ) {
			System.out.println("당신의 성별은 남자");
			} else if (jumin.charAt(7) == '2' || (jumin.charAt(7) == '4')) {
				System.out.println("당신의 성별은 여자");
				} else {
				System.out.println("당신은 외계인?");
				}

				
	}
}
