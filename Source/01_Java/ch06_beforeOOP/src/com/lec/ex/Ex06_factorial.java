package com.lec.ex;
import java.util.Scanner;
// �����ȣ�� : ����ڷκ��� ���� �Է¹޾� �Է¹��� ��!! 
// ���丮�� ����ϴ� �޼ҵ� �̿� (�Է�: 3)! = 3X2X1
public class Ex06_factorial {
	public static void main(String[] args) {

		int su;
		Scanner sc = new Scanner (System.in);
		System.out.println("���丮�� ���");
		do {
			System.out.print("���ڸ� �Է��ϼ��� : ");
			su = sc.nextInt();
		} // 
		while(su<=0);
		long result = factorial(su); // while��
		System.out.println("�Է��Ͻ� " + su + "! = " + result);
		System.out.printf("�Է��� %d! = %d", su, result);
		
		sc.close();
	} // main
	
	private static long factorial(int su) { // su * factorial(su-1)
		// su>1�� ���: su * factorial(su-1)
		if (su==1) { // 1�̸��� ���� main do=while������ ������ �س��� X
			return 1;
		}
		else return su * factorial(su-1); // ���� �� �ڽ��� ȣ��
		
	}
	
	
//	private static long factorial(int su) {
//	// �Ҵ�� ���� Ÿ�԰� �����ϰ� ����Ÿ�� �����ֱ�
//		int result = 1;
//		// �Ϲ�for�� - ����� �Լ��� ���x
//		for(int i=su; i>=1; i--) {
//			result *= i;
//		}
//		return result;
//	}

}
