package com.lec.ex7_product;

public class ProductTestmain {

	public static void main(String[] args) {
		Product p1 = new Product();
		// p1�̶� ��ü�� �����ǰ� infoPrint�� ����ϸ� ��°� ���ÿ� serialNo�� +1 �ȴ�.
		p1.infoPrint();
		
		Product p2 = new Product();
		p2.infoPrint();
		
		System.out.println("static ����=Ŭ���� ����=���� ����(�ϸ� ��α�) count"
				+ ": " + Product.count);

	}

}
