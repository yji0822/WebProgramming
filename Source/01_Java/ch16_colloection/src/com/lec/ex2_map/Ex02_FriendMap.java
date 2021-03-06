package com.lec.ex2_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
// Friend.java
public class Ex02_FriendMap {

	public static void main(String[] args) {
		
		HashMap<String, Friend> friends = new HashMap<String, Friend>(); // 데이터는 아직 없는 객체 생성된 상태
		// key 값이 같으면 put이 안된다!!!
		friends.put("010-9999-9999", new Friend("홍길동", "010-9999-9999"));
		friends.put("010-8888-8888", new Friend("김길동", "010-8888-8888"));
		friends.put("010-7777-9999", new Friend("신길동", "010-7777-9999"));
		friends.put("010-6666-9999", new Friend("마길동", "010-6666-9999"));
		friends.put("010-5555-9999", new Friend("윤길동", "010-5555-9999", new Date(95,12,12)));
		
		// 출력  - 순서대로 출력되지 않는다.
		Iterator<String> iterator = friends.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + "의 데이터는 " + friends.get(key));
		} // while
		
		
	} // main
	
}
