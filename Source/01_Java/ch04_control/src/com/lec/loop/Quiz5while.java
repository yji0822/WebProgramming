package com.lec.loop;

import java.util.Scanner;

// Homework 4 : ��ǻ�Ϳ� ���������� ������ ����� �� ������ ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.
// (��, ������� 0, ������� 1, ����� 2)
// ����ڰ� �� ������ ���������� ������ �ϴ� ���α׷� ����
public class Quiz5while {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, computer;
		do {
			computer = (int)(Math.random()*3);
			System.out.print("����(0), ����(1), ��(2) �� �ϳ� ������ : ");
			you = sc.nextInt();
			if (you == 0) {
				System.out.print("����� ����\t");
			} else if (you == 1) {
				System.out.print("����� ����\t");
			} else if (you == 2) {
				System.out.print("����� ���ڱ�\t");
			} else {
				System.out.print("����� �߸� �¾��. ����");
				you = 3; // ������ ���� ����
			} // if - you���
			
			if (you != 3) { // ��ǻ�Ͱ� �� �Ͱ� ���� ���
				String msg = (computer == 0) ? "���� ����" : (computer == 1) ? "���� ����" : "���� ���ڱ�";
				System.out.println(msg);
				// ����� ���� 3���� : ����, �̰��, ����
				if( (you+1)%3 == computer) {
					System.out.println("����� ����� ");
					break; //* ���� ��� ���� ����
				}else if(you == computer ) {
					System.out.println("����");
				}else {
					System.out.println("����� �̰��� ");
				}// if - ���� ���
			} // if
		}while(true);
		System.out.println("�ȳ��� ������");
	}
}

