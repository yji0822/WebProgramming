package com.lec.ex03_phone;

public class TestMain {

	public static void main(String[] args) {
		// Ÿ�� ��ġ ��Ű��
		AModel a = new AModel(); // AModelŸ���̶�� ��ü. IAcorporation�� ����
		BModel b = new BModel();
		CModel c = new CModel();
		
		IAcorporation[] phone = {a, b, c};
		
		for(IAcorporation p : phone) {
			System.out.println(p.getClass().getName()); // Ŭ���� com.lec.ex03_phone.AModel....
			p.dmbReceive();
			p.lte();
			p.tvRemoteControl();
			System.out.println();
		} // for
	
	} // main
	
} // class
