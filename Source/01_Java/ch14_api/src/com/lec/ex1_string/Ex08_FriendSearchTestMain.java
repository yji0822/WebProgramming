package com.lec.ex1_string;

import java.util.Scanner;

public class Ex08_FriendSearchTestMain {

	public static void main(String[] args) {
		Ex08_Friend[] friends  = { new Ex08_Friend("ȫ�浿", "010-9999-9999", "05-22"),
							new Ex08_Friend("�ű浿", "010-8888-8888", "09-22"),
							new Ex08_Friend("���浿", "010-8888-9999", "08-22"),
							new Ex08_Friend("���浿", "010-7777-7777", "04-22"),
							new Ex08_Friend("��浿", "010-9999-9999", "03-22")};
		
		Scanner sc = new Scanner (System.in);
		
		while(true) {
			System.out.print("�˻��� ��ȭ��ȣ ���ڸ�(��, ���Ḧ ���Ͻø� X�� �Է��ϼ���) : ");
			String searchTel = sc.next(); // �Է¹��� ������ �Ҵ�
			if(searchTel.equalsIgnoreCase("X")) {
				System.out.println("����");
				break;
			}
			boolean searchOK = false;
			
			for(int idx=0; idx<friends.length; idx++) { // �޹�ȣ 4�ڸ� ����
				String tel = friends[idx].getPhone();
				String post = tel.substring(tel.lastIndexOf('-')+1);
				if(post.equals(searchTel)) { //searchTel�� ���ٸ� ���!
					System.out.println(friends[idx]);
					searchOK = true;
				} //if - ��ȭ��ȣ�� ã�� ��� ���̻� �˻����� �ʰ� for�� ��������
			} // for
			if(! searchOK) {
				System.out.println("�˻��Ͻ� ��ȣ�� ��ȸ���� �ʽ��ϴ�.");
			}
		} // while

		
		sc.close();
		
	}
	
}
