package com.lec.ex5_homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/* <������ ����> Member.java / MemberTestMain.java / 
1.  ��N(n)���� �Է��� ������ ȸ������ ����(�̸�, ��ȭ��ȣ, ����, �ּ�)�� ArrayList�� �޴´�
(��, �Է��� ������ �����̸� ���� ���� �޽��� ����Ѵ�)
2.  ArrayList������ �� ���� �����ߴ����� 
d:/webPro/source/1_java/ch17_io/src/com/lec/ex7homework/member.txt ���ϰ� �ܼ�â ���
3. �������ϸ� (Member.java, MemberTestMain.java, member.txt)*/

public class MemberTestMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String           key; // y,n �Է¹޴� ��
		OutputStream     fos = null; // �����;���
		ArrayList<Member> members = new ArrayList<Member>(); 
		
		try {
			fos = new FileOutputStream("D:/webPro/source/01_java/ch17_io/src/com/lec/ex5_homework/member.txt");
			
			while(true) {
				System.out.println("ȸ�� ������ �Է��Ͻðڽ��ϱ�? (y/n)  ");
				key = sc.next();
				if(key.equalsIgnoreCase("n")) {
					break;
				} else if(key.equalsIgnoreCase("y")) {
					System.out.println("ȸ�� ���� �Է�");
					System.out.print("�̸� : ");
					String name = sc.next();
					System.out.print("��ȭ��ȣ : ");
					String tel = sc.next();
					System.out.print("����(0101����): ");
					String birth = sc.next();
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
					String today = sdf.format(date);
					if(birth.equals(today)) {
						System.out.println("��!���� �����̽ñ���!");
					}
					System.out.print("�ּ� : ");
					sc.nextLine(); // �����ʱ�ȭ
					String address = sc.nextLine();
					members.add(new Member(name, tel, birth, address));
				} else {
					System.out.println("(���) �߸� �Է��ϼ̽��ϴ�.");
					System.out.println("---------------------");
					continue;
				}
			} // while
			// ArrayList products ���
			if(members.isEmpty()) {
				System.out.println("�Էµ� ȸ�� ������ �����ϴ�.");
				} else {
					for(Member member : members) {
						System.out.println(member);
						fos.write(member.toString().getBytes());
						}
					System.out.println("..... �̻� " + members.size() + "�� �Է� ��.");
					} // if-else
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			} // try-catch
		} // finally
	
	}

}
