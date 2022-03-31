package com.lec.ex12_store;
// 대학가에 매장2호점: 부대찌개-5,000  비빔밥-5,000 공기밥-무료
public class Store2 extends HeadQuaterStore {
	
	// 생성자
	public Store2(String str) {
		super(str);
	}
	
	// 메소드 오버라이드
	@Override
	public void bude() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void bibib() {
		System.out.println("비빔밥 5,000원");
	}
	@Override
	public void gonggibab() {
		System.out.println("공기밥 무료");
	}
		
	
}
