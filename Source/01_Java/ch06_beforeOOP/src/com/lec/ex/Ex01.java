package com.lec.ex;
// EX01 연결
// 1~10까지의 정수의 합을 출력하고 그 합이 짝수인지 홀수인지 출력
public class Ex01 {
	public static void main(String[] args) {
		// 유지보수를 위해 특정 기능마다 분리해서 사용할 수 있게 해주는 것. 메소드
		// 기능을 빼고 호출해주는 것만 작성해서 짧게 보여주는!
		
		// 1. from~to까지 누적하는 로직
		// 2. 홀짝 판별 로직
		int tot = sum(1, 10);
		System.out.println("1~10까지 누적합: " + tot);
		System.out.println(evenOdd(tot));
		
		tot = sum(10, 100); // (10, 100) 매개변수!
		System.out.println("1~100까지 누적합: " + tot);
		System.out.println(evenOdd(tot));
		
		tot = sum(10);
		System.out.println(tot);
	}
	
	private static int sum(int to) { // 함수의 오버로딩 : 같은 함수이름이 존재해도 매개변수만 다르면 상관 없다.
		int result = 0;
		for(int i=1; i<=to; i++) {
			result += i;
		}
		return result;
	} // 더하고 싶은 값만 입력해서 1부터 그 값까지 총합을 구해주는 함수!
	
	private static String evenOdd(int value) {
		// 리턴을 짝수인지 홀수인지 판별해주는 함수
		return value%2==0 ? "짝수!" : "홀수"; // 삼항연산자 활용
		/*
		String result = null;
		
		if (value%2 ==0) {
			result  = "짝수";
//			return "짝수입니다.";
		}
		else {
			result = "홀수";
//			return "홀수입니다.";
		}
		return result;
		*/
	}
	
	private static int sum(int from, int to) { // from~to까지 누적한 결과 return
	// 이 파일 안에서만 공유가 가능하다.
	// static - 이번주 금요일에 배움 . 클래스에 있는 그대로를 출력할 수 있다.
	// int = 가지고 와야 하는 타입. (리턴타입)
	// sum 이라는 함수에서 int from이라는 형식과, int to라는 형식으루
	// sum(1,10); int from = 1, int to = 10;
		int result = 0;
		for(int i=from; i<=to; i++) {
			result += i; // result = result + i;
		}
		return result; // 메인으로 보내주는 기능!!  반드시 작성해주어야 한다.
	}
	
	
	

}

