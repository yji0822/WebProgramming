package com.lec.condition;

public class Ex03_switch {

	public static void main(String[] args) {
		// switch-case��
		int num1 = 2;
		
		switch(num1) { // ������, ������, ���ڿ��� ����
		case 1:
			System.out.println("1�Դϴ�.");
			break;
		case 2:
			System.out.println("2�Դϴ�.");
			break;
		case 3:
			System.out.println("3�Դϴ�");
			break;
		default: 
			System.out.println("�� ���� �� �Դϴ�.");
		}
		
		
		
//		if (num1 == 1) {
//			System.out.println("1");
//		}
//		else if (num1 == 2) {
//			System.out.println("2");
//		}
//		else if (num1 == 3) {
//			System.out.println("3");
//		}
//		else {
//			System.out.println("�� ���� ���Դϴ�.");
//		}
		
		
	}

}
