package com.lec.ex12_store;
// 주택가에 매장1호점: 부대찌개-5,000 순대국-안팔아
public class Store1 extends HeadQuaterStore {

	// 생성자
	public Store1(String str) {
		super(str);
	}
	
	// 오버라이드 - 부모클래스에서 고정하고 싶은것만 수정
	@Override
	public void bude() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국은 판매하지 않습니다.");
	}
	
	

}
