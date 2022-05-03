package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		
		// 기존의 배열 - 방의 크기를 정해놓고 원하는 방에만 데이터 저장 가능
		System.out.println("1. 기존 배열");
		String[] array = new String[5];
		array[0] = "str0";
		array[1] = "str1";
		array[4] = "str4"; // 2방,3방은 패스해도 된다.
		for(int i = 0; i<array.length; i++) {
			System.out.printf("arr[%d]=%s \t", i, array[i]);
		}
		System.out.println(); // 개행
		for(String arr : array) { // 확장for문
			System.out.print(arr + "\t");
		}
		
		// ArrayList
		System.out.println("\n\n2. ArrayList ");
		ArrayList<String> arrayList = new ArrayList<String>(); // String 형의 ArrayList - 개수지정X
//		ArrayList<int> list = new ArrayList<int>(); // 기초데이터타입은 사용할 수 없다 (object타입만 가능)
		ArrayList<Integer> list = new ArrayList<Integer>(); // wrapper class 이용해서 사용해준다.
		arrayList.add("str0"); // 0번 인덱스 생성 - str0이란 객체 생성 완료
		arrayList.add("str1"); // 1번 인덱스 생성
		arrayList.add("str2"); // 2번 인덱스 생성
		System.out.println(arrayList); // add 한것만큼 index가 쌓인다. [str0, str1, str2]
		arrayList.add(1, "str11111111111"); // 1번 인덱스 - 원래 1번 인덱스는 2번 인덱스로, 원래 2번 인덱스는 3번으로 밀려난다.
		
		// 출력1.
		System.out.println(arrayList);
		// 값 수정
		arrayList.set(1, "11111"); // 1번 인덱스 값 수정
		System.out.println(arrayList);
		// 기본적으로 toString이 오버라이드 되어져 있는 ArrayList
		// 확장 for문을 이용하여 원하는 형태로 출력을 하도록 변경해준다. 배열과 동일한 방식 - 출력2.
		for(String alist : arrayList) {
			System.out.print(alist + "\t");
		} 
		
		System.out.println("\n\n3. remove한 후...(1번 인덱스 삭제)"); // 특정 인덱스를 지운다는 뜻
		arrayList.remove(1); // 1번째 인덱스의 데이터 삭제 (2->1번인덱스, 3->2번인덱스)
		// 중간 인덱스를 삭제하면 자동으로 들여쓰기가 되어서 웬만해서는 사용하지 않는다.
		arrayList.remove(arrayList.size()-1); // 맨 마지막 인덱스 데이터 삭제 (array.length == arrayList.size())
		for(int idx=0; idx<arrayList.size(); idx++) {
			System.out.printf("%d번째 인덱스 값은 %s\t\t", idx, arrayList.get(idx));
		} // arrayList 출력 형식! arrayList.get() == array[idx]
		
		System.out.println(); // 개행
		System.out.println("\n4. arrayList 데이터 삭제");
		arrayList.clear(); // arrayList의 모든 데이터 삭제 - 데이터를 지운 arrayList는 size가 0이 된다.
		// 데이터가 삭제되었는지 확인하는 메소드
		if(arrayList.size() == 0) { 
			System.out.println("arrayList의 데이터는 없습니다. arrayList.size()");
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList의 데이터는 없습니다. arrayList.isEmpty()");
		}
		System.out.println(arrayList);
		
		arrayList = null; // arrayList 자체 삭제 (객체를 지움)
//		System.out.println(arrayList.size()); - 에러. 예외처리 발생
		
	}

}
