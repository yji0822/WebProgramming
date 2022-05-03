package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Ex04_Iterator {

	public static void main(String[] args) {
		
		// List
		ArrayList<String> list = new ArrayList<String>();
		list.add("STR");
		list.add("STR");
		System.out.println(list);
		
		// 출력 - 순서는 Iterator가 정한다.
		System.out.println("*Iterator 출력");
		Iterator<String> iterator1 = list.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		} // 더이상 next 할게 없으면 마지막 위치를 가지면서 출력 종료
		
		// 확장 for문으로 반드시 순서대로 출력할 수 있도록 한다.
		System.out.println( "*확장for문 출력");
		for(String l : list) {
			System.out.println(l);
		}
		
		
		// Map
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("홍길동", "010-0000-0000");
		map.put("김길동", "010-1234-5678"); // 데이터는 같아도 되지만 키값은 같으면 안됨
		
		Iterator<String> iterator2 = map.keySet().iterator(); // 키값으로 이터레이터 사용
		while(iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.println(key + " key의 데이터 : " + map.get(key));
		}
		
		
		// Set
		HashSet<String> set = new HashSet<String>();
		set.add("str0");
		set.add("str1");
		set.add("str1"); // 중복 사용 불가
		
		Iterator<String> iterator3 = set.iterator();
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next());
		}
		
		

	}

}
