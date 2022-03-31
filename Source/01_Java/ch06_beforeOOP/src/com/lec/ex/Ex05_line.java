package com.lec.ex;
/* -------------
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
Hello, World!
~~~~~~~~~~~~~~~
Hello, JAVA!
----------------------------------------
Hello, HONG!
★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
 * 상황에 맞는 라인 구현하는 법
 */
public class Ex05_line {
	public static void main(String[] args) {
	
		printLine('■', 50);
		System.out.println("Hello, World!");
		printLine('~');
		System.out.println("Hello, JAVA!");
		printLine(40);
		System.out.println("Hello, HONG!");
		printLine('★', 40);
	
	} // main
	
	private static void printLine (char c, int cnt) {
		for(int i=0; i<cnt; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	private static void printLine(int cnt) {
		for(int i=0; i<cnt; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
	
	private static void printLine(char c) { // 함수의 오버로딩 - 매개변수로 함수 구분
		for(int i=0; i<15; i++) {
			System.out.print(c);
		}
		System.out.println(); // 얇은 '-' 20개 출력하고 개행
	} 
	
//	private static void printLine() { // 리턴타입이 없고, 매개변수 없는 메소드(함수) void
//		for(int i=0; i<15; i++) {
//			System.out.print('-');
//		}
//		System.out.println(); // 얇은 '-' 20개 출력하고 개행
		
		
//	}

}


