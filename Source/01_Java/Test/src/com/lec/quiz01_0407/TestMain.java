package com.lec.quiz01_0407;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Friend[] friends = { new Friend("홍길동", "010-9999-1234", "서울시 용산구", "05-22"),
				             new Friend("신길동", "010-8888-1234", "경기도 고양시", "04-29"),
				             new Friend("김길동", "010-7777-1234", "부산시 강서구", "06-05"),
				             new Friend("김길동", "010-7777-1234", "부산시 해운대구", "12-12")};
		String input; // 입력받을 변수

		while (true) {
			// 주소 입력
			System.out.print("검색할 주소 앞 글자 2자리(단, 종료를 원하시면 X를 입력하시오) : ");
			input = sc.next();
			if (input.equalsIgnoreCase("x")) {
				System.out.println("프로그램 종료");
				break;
			}
			boolean searchOK = false;
			for (int idx = 0; idx < friends.length; idx++) {
				String address = friends[idx].getAddress();
				String address1 = address.substring(0, 2); // 주소 앞글자 두개 받아오는 변수
				if (address1.equals(input)) {
					System.out.println(friends[idx]);
					searchOK = true;
				}
			} // for
			if(!searchOK) {
			System.out.println("해당 지역에는 사는 친구가 없습니다.");
			break;
			} // if
		} // while

		sc.close();

	} // main

}
