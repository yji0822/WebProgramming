package com.lec.ex7_product;

public class ProductTestmain {

	public static void main(String[] args) {
		Product p1 = new Product();
		// p1이란 객체가 생성되고 infoPrint를 출력하면 출력과 동시에 serialNo가 +1 된다.
		p1.infoPrint();
		
		Product p2 = new Product();
		p2.infoPrint();
		
		System.out.println("static 변수=클래스 변수=공유 변수(일명 깍두기) count"
				+ ": " + Product.count);

	}

}
