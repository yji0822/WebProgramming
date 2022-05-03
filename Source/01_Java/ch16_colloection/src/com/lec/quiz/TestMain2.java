package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String fn;
		HashMap<String, Member> map = new HashMap<String, Member>();
		
		do {
			System.out.println("*** ȸ�� ���� �ý��� ***");
			System.out.println("(ȸ������ �Է�: y, ���� �� ȸ�� ����Ʈ ���: n)");
			fn = sc.next();
			if(fn.equalsIgnoreCase("Y")) {
				System.out.print("�̸� �Է�: ");
				String name = sc.next();
				System.out.print("��ȭ��ȣ �Է�: ");
				String tel = sc.next();
				// *** ������ ������ ��ȭ��ȣ ���� Ȯ�� ***
				// ��ȭ��ȣ�� key���̱� ������  �ߺ��Ǹ� ���� �����Ͱ� ������� ������ �ߺ� Ȯ�� �ʼ�.	
				if(map.get(tel) != null){
					System.out.println("������ ���Ե� ��ȭ��ȣ �Դϴ�.");
					System.out.println();
					continue;
				} 
				System.out.print("�ּ� �Է�: ");
				sc.nextLine(); // buffer �ʱ�ȭ
				String address = sc.nextLine();
				map.put(tel, new Member(name, tel, address));
			} else if(fn.equalsIgnoreCase("N")){
				break;
			}
			else {
				System.out.println("�Է� ����.");
				continue;
			}
		} while(true); // ���� ������� true�� ��� ��� �ݺ����ش�.
		
		if(map.size() == 0) {
			System.out.println("������ ȸ���� �����ϴ�.");
		} else {
			System.out.println("*** ȸ������ ***");
			Iterator<String> iterator = map.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(map.get(key));
			} // while
		} // if-else
		
		sc.close();
		
	}

}
