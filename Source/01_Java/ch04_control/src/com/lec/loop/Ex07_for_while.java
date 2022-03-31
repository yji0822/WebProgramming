package com.lec.loop;
// 실습예제 ⑨ for문과 while문을 이용해서 1~100까지 숫자 중 3의 배수 합(또는 누적합)을 구해보자
public class Ex07_for_while {

	public static void main(String[] args) {
		
		// for
		int sum = 0;
		
		for(int i=1; i<=100; i++) {
			if(i % 3 == 0) { 
				sum += i;
			} // if
		} // for
		System.out.println("for문: 누적합은 " + sum);
		
		
		// while
		sum = 0;
		int i = 0;
		while (i<=100) {
			if (i%3 == 0) {
				sum += i;
			}
			++i;
		}
		System.out.println("while문: " +sum);

		
	}

}
