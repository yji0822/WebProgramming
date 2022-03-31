package com.lec.ex02_store;
// 증권가에 매장3호점: 김치찌개-6,000  부대찌개-7,000  비빔밥-7,000 순대국-6,000
public class Store3 implements HeadQuaterStore {

	private String str;
	// 생성자
	public Store3(String str) {
		this.str = str;
	}
	
	// 함수 오버라이드
	@Override
	public void kimchi() {
		System.out.println("김치찌개 6,000원");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 7,000원");
	}
	@Override
	public void bibib() {
		System.out.println("비빔밥 7,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 6,000원");
	}

	@Override
	public void gonggibab() {
		System.out.println("공기밥 1,000원");
	}
	
	// getter
	public String getStr() {
		return str;
	}
	

}
