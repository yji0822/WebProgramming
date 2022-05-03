package com.lec.quiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String key;
		ArrayList<Member> list = new ArrayList<Member>();
		
		do {
			System.out.println("*** ȸ�� ���� �ý��� ***");
			System.out.println("ȸ���Է� : Y/y, ���� �� ȸ������ ��� : N/n");
			key = sc.next();
			if(key.equalsIgnoreCase("Y")) {
				System.out.print("�̸� �Է�: ");
				String name = sc.next();
				System.out.print("��ȭ��ȣ �Է�: ");
				String tel = sc.next();
				System.out.print("�ּ� �Է�: ");
				sc.nextLine(); // buffer �ʱ�ȭ
				String address = sc.nextLine();
				list.add(new Member(name, tel, address));
				} else if(key.equalsIgnoreCase("N")){
					break; // n�� �ƴ� �ٸ� Ű�� �Է��ϸ� ������������
				}
				else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					System.out.println();
				continue; 
			}
		} while(true); // ���� ������� true�� ��� ��� �ݺ����ش�.
		
		if(list.size() == 0) {
			System.out.println("������ ȸ���� �����ϴ�.");
		} else {
			System.out.println("*** ȸ������ ***");
			Iterator<Member> iterator = list.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			} // while
		} // if-else
		
		sc.close();

	} // main

}
	
