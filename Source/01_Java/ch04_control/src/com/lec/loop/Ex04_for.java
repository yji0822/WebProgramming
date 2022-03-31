package com.lec.loop;
// 실습예제 ④ for문을 이용해서 1~40까지 한줄에 4개씩 출력하시오
// 상품 정렬할 때 많이 쓰인다.
// 1 2 3 4
// 5 6 7 8
// 9 10 11 12...
public class Ex04_for {

	public static void main(String[] args) {
		for(int i=1; i<=40; i++) {
			System.out.print(i + "\t");
			if (i%4 == 0) {
				System.out.println(); // i가 4의 배수면 개행 추가
			} // if
		} // for

	}

}
