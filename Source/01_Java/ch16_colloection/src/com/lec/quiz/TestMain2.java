package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String fn;
		HashMap<String, Member> map = new HashMap<String, Member>();
		
		do {
			System.out.println("*** 회원 가입 시스템 ***");
			System.out.println("(회원정보 입력: y, 종료 및 회원 리스트 출력: n)");
			fn = sc.next();
			if(fn.equalsIgnoreCase("Y")) {
				System.out.print("이름 입력: ");
				String name = sc.next();
				System.out.print("전화번호 입력: ");
				String tel = sc.next();
				// *** 기존에 가입한 전화번호 인지 확인 ***
				// 전화번호가 key값이기 때문에  중복되면 기존 데이터가 사라지기 때문에 중복 확인 필수.	
				if(map.get(tel) != null){
					System.out.println("기존에 가입된 전화번호 입니다.");
					System.out.println();
					continue;
				} 
				System.out.print("주소 입력: ");
				sc.nextLine(); // buffer 초기화
				String address = sc.nextLine();
				map.put(tel, new Member(name, tel, address));
			} else if(fn.equalsIgnoreCase("N")){
				break;
			}
			else {
				System.out.println("입력 오류.");
				continue;
			}
		} while(true); // 위의 문장들이 true일 경우 계속 반복해준다.
		
		if(map.size() == 0) {
			System.out.println("가입한 회원이 없습니다.");
		} else {
			System.out.println("*** 회원정보 ***");
			Iterator<String> iterator = map.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(map.get(key));
			} // while
		} // if-else
		
		sc.close();
		
	}

}
