package com.lec.condition;

import java.util.Scanner;

// ��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�. 
// ��, ����ڴ� ������ ������ �� ���� 0�� �Է��ϰ� ������ �����ϰ��� �� ���� 1�� �Է��ϰ�, 
// ���� �����ϰ��� �� ���� 2�� �Է��Ͽ� ������ �����մϴ�.

// ** ���� Ǭ��!!!!!!
public class Quiz5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("����(0) ����(1) ��(2) �� �Ѱ����� �Է����ּ���: ");
		int user = sc.nextInt();
		int com = (int) (Math.random()*3);
		// ���� ������ �̴µ� ���� ���ڰ� 0!
		
		if (user == 2) { //��
			if(com == 0) {
				System.out.println(com);
				System.out.println("YOU LOSE");
			}
			else if (com == 1) {
				System.out.println(com);
				System.out.println("YOU WIN");
			}
			else {
				System.out.println(com);
				System.out.println("���!");
			}
		}
		else if (user == 1) { //����
			if(com == 0) {
				System.out.println(com);
				System.out.println("YOU WIN");
			}
			else if (com == 2) {
				System.out.println(com);
				System.out.println("YOU LOSE");
			}
			else {
				System.out.println(com);
				System.out.println("���!");
			}			
		}
		else { // ����
			if(com == 1) {
				System.out.println(com);
				System.out.println("YOU LOSE");
			}
			else if (com == 2) {
				System.out.println(com);
				System.out.println("YOU WIN");
			}
			else {
				System.out.println(com);
				System.out.println("���!");
			}		
		}
		
		sc.close();

	}

}
