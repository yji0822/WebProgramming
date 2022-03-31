package com.lec.condition;

public class Ex01_if {

	public static void main(String[] args) {
		int seoulLunchPrice = 5000; // 메모리 4바이트의 서울런치프라이스 변수에 5000원이 쏙!
		
		if(seoulLunchPrice >= 8000) {
			System.out.println("서울 점심값 비싸용 ㅠ");
			// tip) seoul만 치고 ctrl+space 치면 자동완성
		} // 참이 아니면 실행 X
		// 다른 조건을 추가하고 싶을 때는 else if
		else if (seoulLunchPrice >= 6000) {
			System.out.println("그래... 이정도면 뭐...");
		}
		else if (seoulLunchPrice >= 5000) {
			System.out.println("오홍 이런 곳이 있다구??@??@?");
		}
		// 참이 아니어도 실행하고 싶으면 else 문을 작성하자!
		else {
			System.out.println("오 싸다!");
		}
		
		//tip_ ctrl+shift+f - 가독성 있게 정리해주는!
		

	}
	

}
