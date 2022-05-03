package com.lec.quiz02_0407;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//(2) TestMain2.java에서, N이나 n을 입력할 때까지 회원가입 정보(이름, 전화번호, 주소)를 HashMap에 받고, 
// N이나 n을 입력할 경우 가입한 모든 회원들의 정보를 아래와 같이 콘솔창에 출력하는 프로그램을 구현하시오
// (단, HashMap의 킷값은 전화번호, 데이터는 회원정보로 한다)
public class TestMain2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String k;
		String name, tel, address;
		HashMap<String, Customer> customers = new HashMap<String, Customer>();

		do {
			System.out.print("회원 정보 입력 시스템 (입력을 종료하길 원하시면 'n'을 눌러주세요.) ");
			k = sc.next();
			if (k.equalsIgnoreCase("n")) {
				break;
			} else {
				System.out.print("이름 : ");
				name = sc.next();
				System.out.print("전화번호 : ");
				tel = sc.next();
				if (customers.get(tel) != null) {
					System.out.println("기존에 가입된 전화번호 입니다.");
					System.out.println();
					continue;
				}
				System.out.print("주소 : ");
				sc.nextLine(); // 버퍼 초기화
				address = sc.nextLine();
				customers.put(tel, new Customer(name, tel, address));
			} // if-else
		} while (true);
		
		if(customers.size()==0) {
			System.out.println("입력된 회원 정보가 없습니다.");
		} else {
			Iterator<String> iterator = customers.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.print(customers.get(key));
			} // while
		} // if-else
		
		sc.close();

	} // main

}
