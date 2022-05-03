package com.lec.quiz02_0407;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//(2) TestMain2.java����, N�̳� n�� �Է��� ������ ȸ������ ����(�̸�, ��ȭ��ȣ, �ּ�)�� HashMap�� �ް�, 
// N�̳� n�� �Է��� ��� ������ ��� ȸ������ ������ �Ʒ��� ���� �ܼ�â�� ����ϴ� ���α׷��� �����Ͻÿ�
// (��, HashMap�� Ŷ���� ��ȭ��ȣ, �����ʹ� ȸ�������� �Ѵ�)
public class TestMain2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String k;
		String name, tel, address;
		HashMap<String, Customer> customers = new HashMap<String, Customer>();

		do {
			System.out.print("ȸ�� ���� �Է� �ý��� (�Է��� �����ϱ� ���Ͻø� 'n'�� �����ּ���.) ");
			k = sc.next();
			if (k.equalsIgnoreCase("n")) {
				break;
			} else {
				System.out.print("�̸� : ");
				name = sc.next();
				System.out.print("��ȭ��ȣ : ");
				tel = sc.next();
				if (customers.get(tel) != null) {
					System.out.println("������ ���Ե� ��ȭ��ȣ �Դϴ�.");
					System.out.println();
					continue;
				}
				System.out.print("�ּ� : ");
				sc.nextLine(); // ���� �ʱ�ȭ
				address = sc.nextLine();
				customers.put(tel, new Customer(name, tel, address));
			} // if-else
		} while (true);
		
		if(customers.size()==0) {
			System.out.println("�Էµ� ȸ�� ������ �����ϴ�.");
		} else {
			Iterator<String> iterator = customers.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.print(customers.get(key));
			} // while
		} // if-else
		
		sc.close();

	} // main

}
