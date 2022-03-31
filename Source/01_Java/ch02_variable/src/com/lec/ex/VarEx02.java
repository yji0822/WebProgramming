package com.lec.ex;
// println(); 콘솔창에 출력 - 개행 포함
// print(); 콘솔창에 출력 - 개행 미포함
// printf(); 콘솔창에 특정 포맷으로 출력 - 개행미포함
public class VarEx02 {

	public static void main(String[] args) {
		// 형식: 데이터타입 변수명 = 초기값
		int i = 10; 
		// 변수를 선언하자마자 메모리에 4바이트 공간을 잡아준다. 4byte짜리 i라는 메모리 공간에 10을 할당
		byte j = 10;
		// 2byte짜리 j라는 메모리 공간에 10을 할당
		double h = 10.15;
		// 8byte짜리 h라는 메모리 공간에 10.15를 할당
		
		// 수정은 언제 어디서나 가능하다.
		// 위에서부터 아래까지 차근차근 실행이 된다.
		i = 5;
		System.out.println("i=" + i + "\t j=" +j + "\t h=" + h);
		char c1 = 'A'; // 문자 하나만 저장 - A의 아스키코드는 65
		char c2 = 'B';
		System.out.print("c1=" + c1 + "\t c2=" +c2); // 개행 미포함
		System.out.print("c1=" + c1 + "\t c2=" +c2 + "\n"); // \n : 개행!
		// System.out.printf("c1=c1값 /t c2=c2값 \n", args);
		System.out.printf("c1=%c \t c2=%c \n", c1,c2);
		// %c:문자	%d:정수	%f:실수	%s:문자열
		System.out.printf("i=%d, j=%d, h=%f \n", i,j,h);
		System.out.printf("i=%d, j=%d, h=%4.1f \n", i,j,h);
		// h=%4.1f 소수점 전체 4자리 수 중에 1번째 자리만 표시
		// 10.2 // ㅁ10.2 -> 빈공간이랑 소수점까지 포함해서 5자리
		
		System.out.println("끝");

	}

}
