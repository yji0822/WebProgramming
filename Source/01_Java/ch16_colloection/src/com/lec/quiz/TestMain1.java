package com.lec.quiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String key;
		ArrayList<Member> list = new ArrayList<Member>();
		
		do {
			System.out.println("*** 회원 가입 시스템 ***");
			System.out.println("회원입력 : Y/y, 종료 및 회원정보 출력 : N/n");
			key = sc.next();
			if(key.equalsIgnoreCase("Y")) {
				System.out.print("이름 입력: ");
				String name = sc.next();
				System.out.print("전화번호 입력: ");
				String tel = sc.next();
				System.out.print("주소 입력: ");
				sc.nextLine(); // buffer 초기화
				String address = sc.nextLine();
				list.add(new Member(name, tel, address));
				} else if(key.equalsIgnoreCase("N")){
					break; // n이 아닌 다른 키를 입력하면 빠져나오도록
				}
				else {
					System.out.println("잘못 입력하셨습니다.");
					System.out.println();
				continue; 
			}
		} while(true); // 위의 문장들이 true일 경우 계속 반복해준다.
		
		if(list.size() == 0) {
			System.out.println("가입한 회원이 없습니다.");
		} else {
			System.out.println("*** 회원정보 ***");
			Iterator<Member> iterator = list.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			} // while
		} // if-else
		
		sc.close();

	} // main

}
	
