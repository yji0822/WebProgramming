package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt(); // '\n'앞의 숫자를 return
		System.out.println("입력하신 나이 : " + age);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next(); // String return
		// whitespace 앞까지 값만 return (space가 들어가지 전까지만 입력받는 함수)
		System.out.println("입력하신 이름 : " + name);
		
		System.out.print("주소를 입력하세요 : ");
		sc.nextLine();; // 전에 입력하고 버퍼에 남아있는 '\n'을 지워주는 역할
		String address = sc.nextLine(); // String return
		// '\n' 앞에 있는 값을 return하고 
		System.out.println("입력하신 주소는 : " + address); // 빈 string이 들어간 것과 같다.
		
		
		sc.close();
		
	}
	
	
}
