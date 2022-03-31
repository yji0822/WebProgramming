package com.lec.ex02_store;

public class TestMain {
	
	public static void main(String[] args) {
		// 배열으로 변경
		HeadQuaterStore[] store = { new Store1("=== 대학가 1호점 === "),
				                    new Store2("=== 주택가 2호점 === "),
								    new Store3("=== 증권가 3호점 === ")};
		// HeadQuaterStore[] store = { new HeadQuaterStore("=== 본사 === ") 
		// -> 데이터 세팅 불가.... 생성자, 일반메소드, getterSetter 있어도 됨
		
		
		for(HeadQuaterStore st : store) {
			System.out.println(st.getStr());
			st.kimchi();
			st.bude();
			st.bibib();
			st.sunde();
			st.gonggibab();
			System.out.println();
		}
		// 배열은 인덱스로 정의한다.
		
		// 일반 for문
		for(int idx=0; idx<store.length; idx++) {
			System.out.println(store[idx].getStr());
			store[idx].kimchi();
			store[idx].bude();
			store[idx].bibib();
			store[idx].sunde();
			store[idx].gonggibab();
		}
		
		
	}
	
}
