package com.lec.ex02_dataStream;

public class Product {
	
	private String name;  // 이름
	private int    price; // 가격
	private int    ps;    // 재고량
	
	// 생성자
	public Product() {}
	public Product(String name, int price, int ps) {
		this.name = name;
		this.price = price;
		this.ps = ps;
	}
	// 메소드
	@Override
	public String toString() {
		return name + "\t" + price + "\t" + ps;
	}
	
	// setter - 매개변수 없는 것에서 데이터 생성하기 위해서 setter 추가
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	
	
	
	
	
}
