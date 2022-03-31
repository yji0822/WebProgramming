package com.lec.ex1_string;

import java.util.Scanner;

// 배열에 있는 전화번호 찾아서  전체 전화번호 출력 (전화번호 뒷자리 입력받아서)
public class Ex07_searchTel {
	
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999", "010-8888-8888", "010-7777-8888"};
		Scanner sc = new Scanner(System.in);
		String searchTel; // 사용자로부터 뒷자리 전화번호 입력받은 데이터 할당 
		boolean searchOk = false;
		System.out.print("검색하고자 하는 회원의 전화번호 뒷자리는?");
		searchTel = sc.next(); // 뒷자리 입력 ex1234
		for(int idx=0; idx<tels.length; idx++) {
			// idx번째의 전화번호 뒷자리 추출
			String post = tels[idx].substring(tels[idx].lastIndexOf('-')+1); // 맨마지막 - 나오는 인덱스 그 다음부터 출력!
			// post searchTel 비교
			if(post.equals(searchTel)) {
				System.out.println("검색하신 전화번호는 " + tels[idx] + "입니다.");
//				break;
				searchOk = true;
			} // if- 맞는 전화번호를 배열 안에서 찾을 경우 더 이상 검색하지 않고 for문 종료
		} // for
		if(! searchOk) { // searchTel이 배열 전화에 없어서 못찾고 idx가 끝까지 간 경우
			System.out.println("검색하신 전화번호는 없습니다.");
		}
		
		sc.close();
		
		
	} // main

}
