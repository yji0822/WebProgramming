package com.lec.condition;
import java.util.Scanner;
// ����ڷκ��� ������ �Է¹޾� ���� ��� - switch-case��
public class Ex04_switch_hakjum {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("������ �Է����ּ��� : ");
		int score = sc.nextInt();
		int temp = score==100? score-1 : score; 
		// case 10�� �߻��� ���, 101�� ���� A�������� ��µǴ� ���� �߻��� ����
		// 100���� -1�� ���־ 99������ ������ش�.
		temp = (-9<=temp && temp<0) ? -10 : temp;
		// -1������ ģ������ F�������� ��µǴ� ������ �ذ��ϱ� ���� ���׿�����.
		
		switch (temp / 10) {
		case 9:  // ** break �� �ɾ�����!!!
			System.out.println("A");
			break;
		case 8: 
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		case 5: case 4: case 3: case 2: case 1: case 0: 
			System.out.println("F");
			break; //* break �� �Է�����!
		default:
			System.out.println("��ȿ���� ���� ���� �Դϴ�.");
		}
		
		sc.close();

	
	}

}
