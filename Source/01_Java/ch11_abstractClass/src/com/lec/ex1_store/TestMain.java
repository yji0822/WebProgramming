package com.lec.ex1_store;

public class TestMain {
	
	public static void main(String[] args) {
		/*
		HeadQuaterStore st = new HeadQuaterStore(" === 본사 === "); // 5
		Store1 st1 = new Store1(" === 대학가 1호점 === ");
		Store2 st2 = new Store2(" === 주택가 2호점 === ");
		Store3 st3 = new Store3(" === 증권가 3호점 === ");
		*/
		// 타입의 개수가 같기 때문에 굳이 형변환 해주지 않고도 써줄 수 있다.
		
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
