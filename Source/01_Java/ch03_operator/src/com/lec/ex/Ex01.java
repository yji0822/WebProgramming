package com.lec.ex;
// 산술연산자 : +	-	*	/	%(나머지)
public class Ex01 {

	public static void main(String[] args) {
		int n1 = 33, n2 = 10;
		int result; // + - * % 의 결과 
		double resultDouble; // / 의 결과
		
		result = n1 + n2;
		System.out.printf("%d %c %d = %d \n", n1, '+', n2, result ); // 33+10=43
		
		result = n1 - n2;
		System.out.printf("%d %c %d = %d \n", n1, '-', n2, result );
		
		result = n1 * n2;
		System.out.printf("%d %c %d = %d \n", n1, '*', n2, result ); 
		
		result = n1 % n2;
		System.out.printf("%d %c %d = %d \n", n1, '%', n2, result ); 
		
		resultDouble = (double)n1 / n2; // **명시적 형변환
		System.out.printf("(printf) %d %c %d = %f \n", n1, '/', n2, resultDouble ); 
		System.out.println("(println) " + n1 + " / " +n2 + " = " + resultDouble);
		
		// 짝수 홀수 구분법
		if(n1%2 == 0) {
			System.out.println("n1은 짝수");
			System.out.println("n1은 짝수! 그리고 오늘은 금요일ㅋ");
		}
		else {
			System.out.println("n1은 홀수");
			System.out.println("n1은 홀수고 오늘은 드디어 금요일!!!");
		}
		
		// 배수구분법
		if(n1%5 == 0) {
			System.out.println("n1은 5의 배수");
		}
		else {
			System.out.println("n1은 5의 배수가 아님");
		}
	
		
	}
}

