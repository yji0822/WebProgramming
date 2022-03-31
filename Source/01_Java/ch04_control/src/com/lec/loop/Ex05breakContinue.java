package com.lec.loop;
// break : 블럭을 완전히 빠져나감
// continue : 블럭의 실행을 멈추고 증감 부분으로 감

public class Ex05breakContinue {

	public static void main(String[] args) {
//		for (int i=0; true; i++) {
//			System.out.println(i + ". 안녕");
//		} // 무한반복문 - 조심스럽게 써야함..!
		
		
		// 2.
		System.out.println();
		System.out.println();
		for (int i=0; i<=5; i++) {
			if(i==3) {
				break; // 블럭을 완전히 빠져나감
			} // if
			System.out.println(i + ". 안녕");
		} // for
		
		
		// 3.
		System.out.println();		
		for (int i=0; i<=5; i++) {
			if(i==3) {
				continue; // 3일때만 출력안되고 continue되어 패스되어 안나옴
			} // if
			System.out.println(i + ". 안녕");
		} // for
		

	}

}
