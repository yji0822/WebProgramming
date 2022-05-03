package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Random;
//import java.util.TreeSet;

public class Ex02_lotto {

	public static void main(String[] args) {
		
		// 이전방식
//		int[] lotto = new int[6];
		// HashSet 방식
		HashSet<Integer> lotto = new HashSet<Integer>();
//		TreeSet<Integer> lotto = new TreeSet<Integer>();
		
		// 랜덤객체 사용하여 size가 6인지만 확인을 한다.
		Random random = new Random();
//		while(lotto.size() < 6) {
//			lotto.add(random.nextInt(45)+1); // 1~45사이의 정수 난수 add
//		}
//		System.out.println(lotto); // 중복된 수가 나오지 않는다!
		
		// 몇번 돌려서 번호를 출력했는지 확인 - 얼마나 중복됐는지 확인용
		int cnt = 0;
		while(lotto.size() < 6) {
			cnt++;
			lotto.add(random.nextInt(45)+1); // 1~45사이의 정수 난수 add
		}
		System.out.println(cnt + "번 숫자 뽑아 나온 로또 수들 : " +lotto); // 중복된 수가 나오지 않는다!

		
	}

}
