package com.lec.method;
// �������� ������ ���ִ� class ����
public class Arithmetic {

	public int abs(int value) { // static ���� �Լ��� 99%
		int result = (value>=0) ? value : -value; // ������ ���� ���׿�����
//		if(value >=0) {
//			result = value;
//		} else {
//			result = -value;
//		}
		return result;
	}
	
	public static int sum(int to) { // �Լ��� �����ε�
		int result = 0;
		for(int i=1; i<=to; i++) {
			result += i;
		}
		return result;
	} // public or private�� ������ ���� ��Ű�� �ȿ����� ��밡�� 
	// �ݵ�� �ۼ����־�� �ϴ� �κ�!
	
	public static String evenOdd(int value) { 
		return value%2==0 ? "¦��!" : "Ȧ��";
	}
	
	public static int sum(int from, int to) {
	// static - �����Լ����� �ٷ� ������
		int result = 0;
		for(int i=from; i<=to; i++) {
			result += i; // result = result + i;
		}
		return result; 
	}
	

}
