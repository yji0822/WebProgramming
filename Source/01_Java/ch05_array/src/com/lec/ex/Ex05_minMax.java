package com.lec.ex;

import java.util.Scanner;

// (실습예제 1) 사용자로부터 영희, 철수, 길동, 영수, 말자의 키를 입력 받아 평균키를 출력
// 데이터 받아내고 출력하는 것을 좋아한다..!
public class Ex05_minMax {
	public static void main(String[] args) {
		String[] arrName = {"영희", "철수", "길동", "영수", "말자"}; // name[5] = "길똥"; - 에러발생
		int[] 	 arrHeight = new int[arrName.length]; // arrName 방크기만큼 할당
		Scanner sc = new Scanner(System.in);
		int totalHeight = 0; // 0으로 반드시 초기화 해주기. - 입력 받은 키 누적 변수.
		
		for(int idx=0; idx<arrName.length; idx++) {
			System.out.print(arrName[idx] + "의 키는: ");
			arrHeight[idx] = sc.nextInt();
			totalHeight += arrHeight[idx];
		}
		// 평균 키 출력
		System.out.println("평균키는 " + (double)totalHeight/arrName.length);
		
		// 최장신 출력
		
		
		// 최단신 출력

		
	}

}
