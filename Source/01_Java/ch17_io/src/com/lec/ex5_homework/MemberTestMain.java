package com.lec.ex5_homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/* <오늘의 예제> Member.java / MemberTestMain.java / 
1.  “N(n)”을 입력할 때까지 회원가입 정보(이름, 전화번호, 생일, 주소)를 ArrayList에 받는다
(단, 입력한 생일이 오늘이면 생일 축하 메시지 출력한다)
2.  ArrayList정보와 몇 명이 가입했는지를 
d:/webPro/source/1_java/ch17_io/src/com/lec/ex7homework/member.txt 파일과 콘솔창 출력
3. 제출파일명 (Member.java, MemberTestMain.java, member.txt)*/

public class MemberTestMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String           key; // y,n 입력받는 값
		OutputStream     fos = null; // 데이터쓰기
		ArrayList<Member> members = new ArrayList<Member>(); 
		
		try {
			fos = new FileOutputStream("D:/webPro/source/01_java/ch17_io/src/com/lec/ex5_homework/member.txt");
			
			while(true) {
				System.out.println("회원 정보를 입력하시겠습니까? (y/n)  ");
				key = sc.next();
				if(key.equalsIgnoreCase("n")) {
					break;
				} else if(key.equalsIgnoreCase("y")) {
					System.out.println("회원 정보 입력");
					System.out.print("이름 : ");
					String name = sc.next();
					System.out.print("전화번호 : ");
					String tel = sc.next();
					System.out.print("생일(0101형식): ");
					String birth = sc.next();
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
					String today = sdf.format(date);
					if(birth.equals(today)) {
						System.out.println("축!오늘 생일이시군요!");
					}
					System.out.print("주소 : ");
					sc.nextLine(); // 버퍼초기화
					String address = sc.nextLine();
					members.add(new Member(name, tel, birth, address));
				} else {
					System.out.println("(경고) 잘못 입력하셨습니다.");
					System.out.println("---------------------");
					continue;
				}
			} // while
			// ArrayList products 출력
			if(members.isEmpty()) {
				System.out.println("입력된 회원 정보가 없습니다.");
				} else {
					for(Member member : members) {
						System.out.println(member);
						fos.write(member.toString().getBytes());
						}
					System.out.println("..... 이상 " + members.size() + "명 입력 됨.");
					} // if-else
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			} // try-catch
		} // finally
	
	}

}
