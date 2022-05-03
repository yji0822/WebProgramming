package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		System.out.println(list.get(0));
		// list계열은 get할때 인덱스로 access한다 - access하고자 하는 인덱스는 내가 지정하지 않는다

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		// string을 저장하는 Hashmap , intager로 변수 저장
		// Integer=Key값, String-data
		// Key값은 유일해야 한다!
		hashMap.put(11, "str11"); // 11key값에 매핑되는 데이터"str1" 추가한 것 (순서가 없다)
		hashMap.put(20, "str20"); // 20key값에 매핑되는 데이터 "str20" 추가
		hashMap.put(33, "str33"); 
		
		// 출력1.
		System.out.println(hashMap); // {33=str33, 20=str20, 11=str11} - 순서없이 출력되는 것을 알 수 있다
		// HashMap은 for문 사용이 불가하다. (순서대로 들어가져 있지 않기 때문)
		System.out.println(hashMap.get(20)); // key값으로 데이터 get함
		
		System.out.println("remove 전 : " + hashMap);
		hashMap.remove(20); // 20key와 값이 remove
		System.out.println("remove 후 : " + hashMap);
		
		// 데이터 삭제
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "데이터 모두 삭제" : "데이터 있음");

		
		System.out.println("\n== while문 이용한 출력 ==");
		hashMap.put(0, "Hong gildong");
		hashMap.put(10, "Kim donggil");
		hashMap.put(22, "Lee soonsin");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap); // {0=Hong gildong, 22=Lee soonsin, 40=Yu ain, 10=Kim donggil}
		// 순서대로 출력이 되는 것이 아니기 때문에 for문을 사용할 수 없다. 
		// 대신 반복자라는 것을 만든다! tokenizer..!와 같이 key값을 access -> ketSet Iterator라고 한다.
		// 모든 collection은 iterator를 만들 수 있다.
		Iterator<Integer> iterator = hashMap.keySet().iterator(); // hashMap의 키값으로 iterator한다.
		// while문 사용 - 몇번 돌려야 할지 모르니까!
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + "의 데이터는 " + hashMap.get(key)); // next할 수 없을때까지 가져온다.
		} // while
		
		
		
	} // main

}
