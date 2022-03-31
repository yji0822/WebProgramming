package com.lec.loop;
// 중첩 for문 - 생각보다 쓴다.
public class Ex03_for {

	public static void main(String[] args) {
// 예제3) 콘솔창에 다음과 같이 출력되도록 for문을 이용하여 구현하여 보자
//		*
//		**
//		***
//		****
//		*****
		for(int j=1; j<=5; j++) { // 5회 반복(j가 1부터 5까지 반복)
			for(int i=1; i<=j; i++) { // j회 반복(i가 1부터 j까지 반복)
				System.out.print("*"); // print
			} // for i
			System.out.println(); // 개행
		} // for j
		
		
	} // main

} // class
