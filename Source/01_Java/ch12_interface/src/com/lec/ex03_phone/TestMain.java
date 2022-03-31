package com.lec.ex03_phone;

public class TestMain {

	public static void main(String[] args) {
		// 타입 일치 시키기
		AModel a = new AModel(); // AModel타입이라는 객체. IAcorporation도 가능
		BModel b = new BModel();
		CModel c = new CModel();
		
		IAcorporation[] phone = {a, b, c};
		
		for(IAcorporation p : phone) {
			System.out.println(p.getClass().getName()); // 클래스 com.lec.ex03_phone.AModel....
			p.dmbReceive();
			p.lte();
			p.tvRemoteControl();
			System.out.println();
		} // for
	
	} // main
	
} // class
