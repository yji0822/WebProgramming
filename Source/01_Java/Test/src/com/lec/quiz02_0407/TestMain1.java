package com.lec.quiz02_0407;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

// ArrayList
public class TestMain1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name, tel, address;
		String key; // �Է¹��� Ű��
		ArrayList<Customer> customers = new ArrayList<Customer>();
		OutputStream os = null;
		
			try {
				os = new FileOutputStream("D:/webPro/source/01_java/Test/src/com/lec/quiz02_0407/customer.txt");
				while (true) {
					System.out.print("ȸ�� ���� �ý��� (�Է��� ������ ������ n�� �����ּ���.) ");
					key = sc.next();
					if(key.equalsIgnoreCase("n")) {
						break;
					} 
					System.out.print("�̸� : ");
					name = sc.next();
					System.out.print("��ȭ��ȣ : "); 
					tel = sc.next();
					System.out.print("�ּ� : ");
					sc.nextLine(); // ���� �ʱ�ȭ
					address = sc.nextLine();
					customers.add(new Customer(name, tel, address));
				} // while
				if(customers.isEmpty()) {
					System.out.println("���Ե� ȸ���� �����ϴ�.");
				} else {
					for(Customer c : customers) {
					System.out.print(c);
					os.write(c.toString().getBytes());
					} // for
					System.out.println("\t\t\t ...");
				} // if-else
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				// �ݾ��ֱ�
				if(os != null) {
					try {
						os.close();
					} catch (IOException ignore) {}
				} // if
			} // finally
			
			sc.close();

	} // main

} 
