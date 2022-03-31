package com.lec.ex3_math;

import java.util.Random;

// 로또번호 6개 뽑기
public class Ex04 {

	public static void main(String[] args) {
		/* 배열단점
		 * 1. 크기 고정
		 * 2. 정렬 X 
		 * 3. 중복제거 X
		 * 배열 정리 - arrayList - Java Collection 트리형 자료구조
		 */
		
		int[] lotto = new int[6]; // 로또라는 변수에 6개의 방 생성
		Random random = new Random();
		
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (random.nextInt(45)+1);
		} // for // 중복된 로또번호가 발생될 수 있다. - 반점짜리 코딩
		
		for(int i=0; i<lotto.length; i++) {
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					// i번째가 j번째 수보다 크면 자리를 바꾸어 준다.
					int temp = lotto[i]; // 임시로 저장하는 변수
					lotto[i] = lotto[j];
					lotto[j] = temp;
				} // if
			}// for j - 오름차순 정렬로직
		} // for i
		
		for(int l : lotto) {
			System.out.print(l + "\t");
		} // 출력
		
		
		
	} // main

}
