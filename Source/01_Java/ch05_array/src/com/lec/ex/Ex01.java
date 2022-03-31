package com.lec.ex;

public class Ex01 {

	public static void main(String[] args) {
		int i = 10; // 변수의 선언과 함께 동시 초기화
		
		// ★ 1. 배열변수 선언과 동시에 초기화
		int[] iArr = {10, 20, 30, 40, 50}; // int 배열 타입이다..! 라는 의미 // pdf 파일 참고
		iArr[2] = 300; // 값변경 가능. 배열은 index로 접근 가능하다. (0~4) 무조건 0부터 시작한다.
		// 0~4 : iArr.lenght-1 까지
		// for문을 돌리는 것이 유용하다
		for (int idx = 0; idx<iArr.length; idx++) { // 0부터 iArr.length만큼 배열 출력
			System.out.println(iArr[idx]);
		} 
		// ctrl + d : 한줄 지우기 - 공백 지울때 유용
		// Alt키 누르고 화살표 위아래를 누르면 위아래로 줄 변경 가능
		
		// ★ 2. 배열 변수 선언과 배열 메모리 공간 확보
//		int j;
//		j = 20;
		System.out.println();
		// 배열 공간 확보
		int[] iArr2 = new int[5]; // 5만큼의 배열 크기 설정 (※ 한번 지정된 배열 크기는 지정 불가!!※)
		for (int idx = 0; idx<iArr2.length; idx++) {
			System.out.printf("iArr[%d] = %d \n", idx, iArr2[idx]);
		} // 레퍼런스변수인 배열은 초기값이 '0'으로 세팅되어 있는 것을 확인할 수 있음.
		
		// 값 설정
		System.out.println();
		iArr2[0] = 999;
		iArr2[1] = 888;
		for (int idx = 0; idx<iArr2.length; idx++) {
			System.out.printf("iArr[%d] = %d \n", idx, iArr2[idx]);
		}
		
		// ★3. 배열 변수 선언
		int[] iArr3;
		iArr3 = new int[3]; // 메모리 공간 할당, 값은 0으로 초기화(레퍼런스 변수)
		// iArr3[0]~iArr3[2] - 3개
		for (int idx=0; idx<iArr3.length; idx++) {
			System.out.printf("iArr3[%d] = %d \n", idx, iArr3[idx]);
		}
		
		// 일반 for문  확장 for문
		
	}

}
