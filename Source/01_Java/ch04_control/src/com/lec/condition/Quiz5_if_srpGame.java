package com.lec.condition;

import java.util.Scanner;

public class Quiz5_if_srpGame {

	public static void main(String[] args) {
		// ��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�. 
		// ��, ����ڴ� ������ ������ �� ���� 0�� �Է��ϰ� ������ �����ϰ��� �� ���� 1�� �Է��ϰ�, 
		// ���� �����ϰ��� �� ���� 2�� �Է��Ͽ� ������ �����մϴ�.
		
		Scanner sc = new Scanner (System.in);
		int you;
		int computer = (int)(Math.random()*3);
		// 0 <= Math.random() < 1 
		// 0 <= Math.random()*3 < 3 -3���� ���ڸ� �̴´ٴ� �ǹ�
		// 0 <= (int) Math.random() -0,1,2 
		// 0 <= ((int) Math.random()*3) -�ϼ���
		System.out.print("����(0) ����(1) ��(2) �� �ϳ��� �����ϼ���: ");
		you = sc.nextInt(); // ������ �Է� ����
		if (you == 0) {
			System.out.print("you ���� \t");
		}
		else if (you == 1) {
			System.out.print("you ���� \t");
		}
		else if (you == 2) {
			System.out.print("you �� \t");
		}
		else {
			System.out.println("�߸� �Է��߽��ϴ�.");
			you=3; // ���α׷��� ������ ���ؼ� 3�� �־��ش�.
		}
		
		if(you != 3) { // ��ǻ�Ͱ� �� �Ͱ� ���� ���
			// ���׿����� ��� *** �������� ���� ����Ѵ�.
			String msg = (computer == 0)? "com ���� " : (computer==1)? "com ����" : "com ��";
			System.out.println(msg);
			if(you == 0) {
				if (computer == 0) {
				System.out.println("DRAW");
				}
				else if (computer == 1) {
					System.out.println("COM WIN");
				}
				else {
					System.out.println("YOU WIN");
				}
			}
			else if(you == 1) {
				if (computer == 0) {
					System.out.println("YOU WIN");
					}
					else if (computer == 1) {
						System.out.println("DRAW");
					}
					else {
						System.out.println("COM WIN");
					}
			}
			else if(you == 2) {
				if (computer == 0) {
					System.out.println("COM WIN");
					} // if
					else if (computer == 1) {
						System.out.println("YOU WIN");
					} // else if
					else {
						System.out.println("DRAW");
					} // else
			} // else if
		} // if
		
		sc.close();

	}

}
