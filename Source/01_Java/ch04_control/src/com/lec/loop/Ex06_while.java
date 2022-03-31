package com.lec.loop;
// 실습예제 ⑦ 10. 9. 8. 7. 6. 5. 4. 3. 2. 1. 출력
public class Ex06_while {

	public static void main(String[] args) {

//		for (int i=10; i>=1; i--) {
//			System.out.print( i + ". ");
//		}
		
		
		// while 초기화와 증감 불가 
		int i = 10; // 변수선언으로 초기화를 해준다.
		while (i >= 1) {
			System.out.print( i + ". ");
			i--; // 밑에 증감을 표현해주어야 한다.
		}
		
		
		
	}

}
