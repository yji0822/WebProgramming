package com.lec.ex;
// 1~10������ ������ ���� ����ϰ� �� ���� ¦������ Ȧ������ ���
// for���� ���׿�����.
public class Ex02 {
	public static void main(String[] args) {
		int tot = 0;
		
		for(int i=1; i<=10; i++) {
			tot += i;
		}
		System.out.println("������ ����: " + tot);
		
		String msg;
		if (tot%2 == 0) {
			msg = "¦��";
		}
		else {
			msg = "Ȧ��";
		}
		System.out.println(msg); // tot=55 - Ȧ��
		
		
	}

}
