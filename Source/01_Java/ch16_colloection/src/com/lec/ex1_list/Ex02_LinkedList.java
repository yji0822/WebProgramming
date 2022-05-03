package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex02_LinkedList {

	public static void main(String[] args) {
		// ArrayList
		ArrayList<String> arrayList = new ArrayList<String>();
		// LinkedList 
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("Str0"); // 0번 인덱스
		linkedList.add("Str1"); // 1번 인덱스
		linkedList.add("Str2"); // 2번 인덱스
		linkedList.add("Str3"); // 3번 인덱스
		linkedList.add(1, "Str1234"); // 1번인덱스
		
		// 출력
		System.out.
		println(linkedList);
		for(String list : linkedList) {
			System.out.println(list);
		} 
		
		// 데이터 초기화
		linkedList.clear(); // remove
		System.out.println(linkedList.isEmpty() ? "데이터가 없습니다." : "데이터가 있습니다.");
		
	}

}
