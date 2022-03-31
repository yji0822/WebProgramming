package com.lec.ex;
// 논리연산자 *** : &&(AND)  ||(OR)   
// 춘향이가 이쁘고&&착하다 / 이쁘거나||착하다 
public class Ex04 {

	public static void main(String[] args) {
		int i = 1;
		int j = 10;
		int h = 10;
		
		// AND
		boolean result = ( (i>j) && (++j>h) ); // F && T 
		// **** 앞의 연산이 F이기 때문에 관계 없이 뒤에 연산은 패스된다. ****
		// && 연산자 좌항이 false일 경우, 우항은 실행하지 않음.
		System.out.println("result=" +result+ "\t j=" +j); // false 증가안된 j값 10
		result = ( (i<j) && (++j>h) ); // T && T 
		System.out.println("result=" +result+ "\t j=" +j); // true 증가된 j값 11
		
		// OR
		// || 연산자 좌항이 true일 때는 우항 실행 안함.
		result = ( (i<j) || (++j>h) ); // 좌항의 결과가 T로 뒤의 연산 자동 패스
		// 연산자우선순위로 괄호를 제거해도 동일한 값이 나오지만 가독성을 위해 사용해주자!
		System.out.println("result=" +result+ "\t j=" +j); // true 전에 증가된 값 11
		
		
	}

}
