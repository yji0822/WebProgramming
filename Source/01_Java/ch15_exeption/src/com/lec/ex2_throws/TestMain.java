package com.lec.ex2_throws;

public class TestMain {

	public static void main(String[] args) {
		
		try { // �����Լ������� throws�ϰ� �����ֱ� ���� �׳� try catch���� ������ִ� ���� ����.
			new ThrowsEx(); // ������ ȣ��
		} catch (Exception e) {
			System.out.println("(error msg) " + e.getMessage());
		} 
		
	}

}
