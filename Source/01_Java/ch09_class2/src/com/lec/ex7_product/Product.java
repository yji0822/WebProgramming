package com.lec.ex7_product;

public class Product {
	
	private int serialNo; // 객체 고유의 번호 101, 102, 103...  - acdl123kesd이런식ㅋㅋ
	public static int count = 100; // 객체를 하나씩 증가시킬때마다 하나씩 증가하도록 해줄 것.
	
	// 생성자
	public Product() {
		serialNo = ++count; // 호출되자마자 바로 하나 증가시켜주는 방식
	}
	// 메소드
	public void infoPrint() {
		System.out.println("serialNo = " + serialNo + "\t 공유변수 count = " + count);
	}
	
}
