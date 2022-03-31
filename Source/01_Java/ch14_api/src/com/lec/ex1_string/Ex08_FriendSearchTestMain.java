package com.lec.ex1_string;

import java.util.Scanner;

public class Ex08_FriendSearchTestMain {

	public static void main(String[] args) {
		Ex08_Friend[] friends  = { new Ex08_Friend("홍길동", "010-9999-9999", "05-22"),
							new Ex08_Friend("신길동", "010-8888-8888", "09-22"),
							new Ex08_Friend("마길동", "010-8888-9999", "08-22"),
							new Ex08_Friend("윤길동", "010-7777-7777", "04-22"),
							new Ex08_Friend("김길동", "010-9999-9999", "03-22")};
		
		Scanner sc = new Scanner (System.in);
		
		while(true) {
			System.out.print("검색할 전화번호 뒷자리(단, 종료를 원하시면 X를 입력하세요) : ");
			String searchTel = sc.next(); // 입력받은 데이터 할당
			if(searchTel.equalsIgnoreCase("X")) {
				System.out.println("종료");
				break;
			}
			boolean searchOK = false;
			
			for(int idx=0; idx<friends.length; idx++) { // 뒷번호 4자리 추출
				String tel = friends[idx].getPhone();
				String post = tel.substring(tel.lastIndexOf('-')+1);
				if(post.equals(searchTel)) { //searchTel과 같다면 출력!
					System.out.println(friends[idx]);
					searchOK = true;
				} //if - 전화번호를 찾을 경우 더이상 검색하지 않고 for문 빠져나감
			} // for
			if(! searchOK) {
				System.out.println("검색하신 번호는 조회되지 않습니다.");
			}
		} // while

		
		sc.close();
		
	}
	
}
