package com.lec.condition;

public class Ex03_switch {

	public static void main(String[] args) {
		// switch-case문
		int num1 = 2;
		
		switch(num1) { // 정수형, 문자형, 문자열만 가능
		case 1:
			System.out.println("1입니다.");
			break;
		case 2:
			System.out.println("2입니다.");
			break;
		case 3:
			System.out.println("3입니다");
			break;
		default: 
			System.out.println("그 외의 수 입니다.");
		}
		
		
		
//		if (num1 == 1) {
//			System.out.println("1");
//		}
//		else if (num1 == 2) {
//			System.out.println("2");
//		}
//		else if (num1 == 3) {
//			System.out.println("3");
//		}
//		else {
//			System.out.println("그 외의 수입니다.");
//		}
		
		
	}

}
