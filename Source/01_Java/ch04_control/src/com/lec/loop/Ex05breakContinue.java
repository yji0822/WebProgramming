package com.lec.loop;
// break : ���� ������ ��������
// continue : ���� ������ ���߰� ���� �κ����� ��

public class Ex05breakContinue {

	public static void main(String[] args) {
//		for (int i=0; true; i++) {
//			System.out.println(i + ". �ȳ�");
//		} // ���ѹݺ��� - ���ɽ����� �����..!
		
		
		// 2.
		System.out.println();
		System.out.println();
		for (int i=0; i<=5; i++) {
			if(i==3) {
				break; // ���� ������ ��������
			} // if
			System.out.println(i + ". �ȳ�");
		} // for
		
		
		// 3.
		System.out.println();		
		for (int i=0; i<=5; i++) {
			if(i==3) {
				continue; // 3�϶��� ��¾ȵǰ� continue�Ǿ� �н��Ǿ� �ȳ���
			} // if
			System.out.println(i + ". �ȳ�");
		} // for
		

	}

}
