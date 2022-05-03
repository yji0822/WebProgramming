package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	
	public static void main(String[] args) {
		
		String[] arr = new String[5]; // String형의 일반 배열
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("str0");
		hashSet.add("str1"); // 인덱스 값이 없다.
		System.out.println(hashSet); // [str1, str0]
		
		hashSet.add("str1"); // 중복된 값을 또 넣어주면 들어가지 않는다.
		System.out.println(hashSet); // [str1, str0]
		// 인덱스나 키값이 모두 존재하지 않는다. - Iterator 필요.
		// 나름대로의 순서를 정해서 Iterator 해준다. - 본연의 데이터만으로 Iterator 해줌
		Iterator<String> iterator = hashSet.iterator();
		while(iterator.hasNext()) { // next할거 있는지 없는지 확인
			System.out.println(iterator.next()); // next한거 가져온 다음 next를 해준다. 
		} 
		// 포인트가 밑을 가르킨다면 while문은 종료되고 while문은 두번 실행되지 않는다. 
		// 실행하기 위해서는 Iterator를 두번 만들어서 실행해주어야 함
		
	} // main()

}
