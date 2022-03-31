package com.lec.ex02_store;
// 대학가에 2호점: 김치찌개-5,000 부대찌개-5,000 비빔밥-5,000 순대국-5,000  공기밥-무료
public class Store2 implements HeadQuaterStore {
	private String str;
	// 생성자
	public Store2(String str) {
		this.str = str;
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

	@Override
	public void kimchi() {
		System.out.println("김치찌개 5,000원");
	}

	@Override
	public void sunde() {
		System.out.println("순대국 5,000원");
	}
	
	// getter
	public String getStr() {
		return str;
	}
	
}
