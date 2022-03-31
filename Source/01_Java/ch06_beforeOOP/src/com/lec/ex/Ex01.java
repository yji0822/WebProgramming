package com.lec.ex;
// EX01 ����
// 1~10������ ������ ���� ����ϰ� �� ���� ¦������ Ȧ������ ���
public class Ex01 {
	public static void main(String[] args) {
		// ���������� ���� Ư�� ��ɸ��� �и��ؼ� ����� �� �ְ� ���ִ� ��. �޼ҵ�
		// ����� ���� ȣ�����ִ� �͸� �ۼ��ؼ� ª�� �����ִ�!
		
		// 1. from~to���� �����ϴ� ����
		// 2. Ȧ¦ �Ǻ� ����
		int tot = sum(1, 10);
		System.out.println("1~10���� ������: " + tot);
		System.out.println(evenOdd(tot));
		
		tot = sum(10, 100); // (10, 100) �Ű�����!
		System.out.println("1~100���� ������: " + tot);
		System.out.println(evenOdd(tot));
		
		tot = sum(10);
		System.out.println(tot);
	}
	
	private static int sum(int to) { // �Լ��� �����ε� : ���� �Լ��̸��� �����ص� �Ű������� �ٸ��� ��� ����.
		int result = 0;
		for(int i=1; i<=to; i++) {
			result += i;
		}
		return result;
	} // ���ϰ� ���� ���� �Է��ؼ� 1���� �� ������ ������ �����ִ� �Լ�!
	
	private static String evenOdd(int value) {
		// ������ ¦������ Ȧ������ �Ǻ����ִ� �Լ�
		return value%2==0 ? "¦��!" : "Ȧ��"; // ���׿����� Ȱ��
		/*
		String result = null;
		
		if (value%2 ==0) {
			result  = "¦��";
//			return "¦���Դϴ�.";
		}
		else {
			result = "Ȧ��";
//			return "Ȧ���Դϴ�.";
		}
		return result;
		*/
	}
	
	private static int sum(int from, int to) { // from~to���� ������ ��� return
	// �� ���� �ȿ����� ������ �����ϴ�.
	// static - �̹��� �ݿ��Ͽ� ��� . Ŭ������ �ִ� �״�θ� ����� �� �ִ�.
	// int = ������ �;� �ϴ� Ÿ��. (����Ÿ��)
	// sum �̶�� �Լ����� int from�̶�� ���İ�, int to��� ��������
	// sum(1,10); int from = 1, int to = 10;
		int result = 0;
		for(int i=from; i<=to; i++) {
			result += i; // result = result + i;
		}
		return result; // �������� �����ִ� ���!!  �ݵ�� �ۼ����־�� �Ѵ�.
	}
	
	
	

}

