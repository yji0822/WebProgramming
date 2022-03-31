package com.lec.ex1_string;
// String ����(10����) > StringBuffer ����(10����) > StringBuilder ����(10����) - ��������
public class Ex11_speedCheck {

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis()); //1970��1��1�Ϻ��� ���ݱ����� �и�����
		
		// String ���� (10����) - �ð�üũ
		String str = "A";
		long startTime = System.currentTimeMillis(); // ���� ���� ������ 1970.01.01������ �и�����
		for(int i=0; i<100000; i++) { // 10���� �����ϴ� ����
			str = str + "a";
		}
		long endTime = System.currentTimeMillis(); // ���������� ������ 1970.01.01������ �и�����
		System.out.println("String 10���� ���� ��� �ð� : " + (endTime-startTime));
		
		// StringBuffer - 10���� ���� �����ؼ� �ð� üũ
		StringBuffer strBuf = new StringBuffer("A");
		startTime = System.currentTimeMillis();
		for(int i =0; i<100000; i++) {
			strBuf.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer 10���� ���� ��� �ð� : " + (endTime-startTime));
		
		// StringBuilder - 10���� �ð�üũ
		StringBuilder strBuld = new StringBuilder("A");
		startTime = System.currentTimeMillis();
		for(int i =0; i<100000; i++) {
			strBuld.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder 10���� ���� ��� �ð� : " + (endTime-startTime));
	}
	
}
