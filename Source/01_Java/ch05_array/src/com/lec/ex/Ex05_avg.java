package com.lec.ex;

import java.util.Scanner;

// (실습예제 1-1) 사용자로부터 영희, 철수, 길동, 영수, 말자의 키를 입력 받아 평균키를 출력
// 최장신과 최단신을 출력하자
// 데이터 받아내고 출력하는 것을 좋아한다..!
public class Ex05_avg {
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
		
		sc.close();
		
		// 문제 2) 최장신의 이름과 키, 최단신의 이름과 키 출력
		int minHeight = 999, minIdx = -1; // 최단신 키 저장 변수 (큰 것으로 초기값 설정), index(위치) 변수
		int maxHeight = 0, maxIdx = 0; // (보통 0이나 -999설정) 최장신 키와 index(위치) 설정
		// maxIdx, minIdx 의 값을 초기화를 해줘야 if문 돌아갈때 비교가 가능하다.(보통 초기화는 -1이나 0으로 설정)
		
		for(int i=0; i<arrName.length; i++) {
			if(arrHeight[i] < minHeight) {
				minHeight = arrHeight[i];
				minIdx = i;
			} // if - 최단신의 키와 index 찾기
			if(arrHeight[i] > maxHeight) {
				maxHeight = arrHeight[i];
				maxIdx = i;
			} // if - 최장신의 키와 index 찾기
		} // for
		System.out.printf("최장신 학생은 %s, 키는 %d \n", arrName[maxIdx], maxHeight);
		System.out.printf("최단신 학생은 %s, 키는 %d \n", arrName[minIdx], minHeight);
		
		


		
	}

}
