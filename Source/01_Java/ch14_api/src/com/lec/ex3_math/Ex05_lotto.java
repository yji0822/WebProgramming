package com.lec.ex3_math;

import java.util.Random;

// 로또번호 6개 뽑기
public class Ex05_lotto {

	public static void main(String[] args) {
			
		int[] lotto = new int[6]; // 로또라는 변수에 6개의 방 생성
		Random random = new Random();
		
		for(int idx=0; idx<lotto.length; idx++) {
//			lotto[i] = (random.nextInt(45)+1);
			int temp = random.nextInt(45)+1; // 뽑은 난수를 임시 변수에 저장하고
			boolean ok = true; // 뽑은 난수가 중복이 아닐 경우 true / 중복일 경우 false
			for(int i=0; i<idx; i++) {
				if(temp == lotto[i]) { // 뽑은 난수가 중복이니 다시 뽑아야 함
					idx--;
					ok = false;
					break;
				}
			} // for: 발생된 난수가 이전 앞방에 저장되었었는지 확인(중복된 난수인지 확인)
			if(ok) { // ok = true라면
				lotto[idx] = temp;
			}
		} // for 
		
		for(int i=0; i<lotto.length; i++) {
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					// i번째가 j번째 수보다 크면 자리를 바꾸어 준다.
					int temp = lotto[i]; // 임시로 저장하는 변수
					lotto[i] = lotto[j];
					lotto[j] = temp;
				} // if
			}// for j - 오름차순 정렬로직
		} // for i - 오름차순 정렬로직
		
		for(int l : lotto) {
			System.out.print(l + "\t");
		} // 출력
		
		
		
	} // main

}
