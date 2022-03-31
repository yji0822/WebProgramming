package com.lec.ex1_string;

import java.util.Scanner;

// 전화번호 받아, 입력받은 전화번호, 짝수번째 문자, 거꾸로, 전화번호 앞자리, 전화번호 뒷자리
// jsp 에서 더 다루기 때문에 한번 더 해보기!
public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String tel;
		
		do {	// while(true) break 사용해서 도 해보기..!
			System.out.print("전화번호를 입력하세요 (형식 : 010-9898-1234)");
			tel = sc.next(); // string 입력 - 스페이스는 안된다!
			System.out.println("입력한 전화번호는 : " + tel);
		System.out.print("짝수번째 문자열 : ");
		for(int i=0; i<tel.length(); i++)
			if(i%2 == 0) {
				System.out.print(tel.charAt(i)); // 짝수번째 문자 출력
			} else {
				System.out.print(' ');
			}
		System.out.println(); // 개행
		
		System.out.print("문자를 거꾸로 출력 : ");
		for(int i=tel.length()-1; i>=0; i--) {
			System.out.print(tel.charAt(i));
		}
		System.out.println();
		
		int first = tel.indexOf('-'); // 첫번째 '-'가 나오는 인덱스
		int last = tel.lastIndexOf('-'); // 마지막 '-'가 나오는 인덱스
		
//		tel.indexOf('-'); //-가 몇번째 오는지
		String pre = tel.substring(0, first); // 전화번호 앞자리 출력 '010'		
		System.out.println("앞자리 : " + pre); // 010 substring indexof

		String post = tel.substring(tel.lastIndexOf('-')+1); // 전화번호 뒷자리 출력 '7890' 여섯번째 ('-') 지나 7번째부터 끝까지 출력하기
		System.out.println("뒷자리 : " + post); // 7890
		
		String mid = tel.substring(first+1, last);
		System.out.println("중간자리 : " + mid);
		
		} while(! tel.equalsIgnoreCase("x"));
		System.out.println("done");
		
		
		sc.close();
		
	}
}
