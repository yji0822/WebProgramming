package com.lec.ex;
// ** ���׿�����  -  (����) ? (���ϰ�� ���� ��/��) : (�����ϰ�� ���� ��/��)
public class Ex06 {

	public static void main(String[] args) {
		int h = 100;
		String result;
		
		System.out.println("���ǹ� if");
		if(h%2 == 0) {
			result = "¦��";
		}
		else {
			result = "Ȧ��";
		}
		System.out.println(result);
		
		System.out.println("���׿�����");
		result = (h%2==0) ? "¦" : "Ȧ";
		
		System.out.println(result);

		
	}

}
