package com.lec.ex02_store;
// 주택가에 1호점: 김치찌개-4,500 부대찌개-5,000 비빔밥-6,000 순대국-안팔아 공기밥-1,000원
public class Store1 implements HeadQuaterStore {

	private String str;
	
	public Store1(String str) {
		this.str = str;
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

	@Override
	public void kimchi() {
		System.out.println("김치찌개 5,000원");
	}

	@Override
	public void bibib() {
		System.out.println("비빔밥 6,000원");
	}

	@Override
	public void gonggibab() {
		System.out.println("공기밥 1,000원");
	}

	// getter&setter
	public String getStr() {
		return str;
	} // 이거만 쓴다.
	public void setStr(String str) {
		this.str = str;
	}
	

}
