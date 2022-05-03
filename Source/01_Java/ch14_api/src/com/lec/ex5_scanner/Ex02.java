package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주소를 입력하세요 : ");
		// sc.nextLine(); 맨 처음에 할 경우에는 사용하지 않는다.
		String address = sc.nextLine();
		System.out.println("입력하신 주소는 " + address);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.println("입력하신 이름은 " + name);
		
		sc.close();
		
	}

}
