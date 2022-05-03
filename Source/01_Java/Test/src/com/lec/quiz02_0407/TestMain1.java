package com.lec.quiz02_0407;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

// ArrayList
public class TestMain1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name, tel, address;
		String key; // 입력받을 키값
		ArrayList<Customer> customers = new ArrayList<Customer>();
		OutputStream os = null;
		
			try {
				os = new FileOutputStream("D:/webPro/source/01_java/Test/src/com/lec/quiz02_0407/customer.txt");
				while (true) {
					System.out.print("회원 가입 시스템 (입력을 원하지 않으면 n을 눌러주세요.) ");
					key = sc.next();
					if(key.equalsIgnoreCase("n")) {
						break;
					} 
					System.out.print("이름 : ");
					name = sc.next();
					System.out.print("전화번호 : "); 
					tel = sc.next();
					System.out.print("주소 : ");
					sc.nextLine(); // 버퍼 초기화
					address = sc.nextLine();
					customers.add(new Customer(name, tel, address));
				} // while
				if(customers.isEmpty()) {
					System.out.println("가입된 회원이 없습니다.");
				} else {
					for(Customer c : customers) {
					System.out.print(c);
					os.write(c.toString().getBytes());
					} // for
					System.out.println("\t\t\t ...");
				} // if-else
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				// 닫아주기
				if(os != null) {
					try {
						os.close();
					} catch (IOException ignore) {}
				} // if
			} // finally
			
			sc.close();

	} // main

} 
