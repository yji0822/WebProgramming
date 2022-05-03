package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;

import com.lec.ex2_map.Friend;

public class Ex04_FriendArrayList {

	public static void main(String[] args) {
		
		// 기존의 배열 방식
		Friend[] friends = new Friend[5];
		friends[0] = new Friend("홍", "010-9999-9999");
		friends[1] = new Friend("홍", "010-8888-8888");
		for(int i=0; i<friends.length; i++) {
			System.out.println(friends[i]);
		}
		
		/** ArrayList : index가 있고, 중복 허용 **/
		System.out.println("\nArrayList");
		ArrayList<Friend> fs = new ArrayList<Friend>(); 
		// index에 차곡차곡 쌓인다
		fs.add(new Friend("홍1", "010-9999-9999")); // 0번인덱스
//		fs.add(2, new Friend("김길동", "010-8888-8888")); // 2번 인덱스가 없는데 add를 해주면 오류 발생
		fs.add(new Friend("김1", "010-8888-8888")); // 1번 인덱스
		Friend temp = new Friend("이1", "010-7777-7777", new Date(95,11,12));
		fs.add(temp); // 2번 인덱스
		for(int i=0; i<fs.size(); i++) {
			System.out.println(fs.get(i));
		}
		

	} // main()

}
