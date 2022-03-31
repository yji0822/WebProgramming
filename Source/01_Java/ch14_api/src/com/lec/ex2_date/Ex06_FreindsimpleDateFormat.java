package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex1_string.Ex08_Friend;

public class Ex06_FreindsimpleDateFormat {

	public static void main(String[] args) {

		Ex08_Friend[] friends = { new Ex08_Friend("ȫ�浿", "010-9999-9999", "03-28"),
		       					new Ex08_Friend("�ű浿", "010-8888-8888", "09-28"),
				    			new Ex08_Friend("���浿", "010-8888-9999", "05-28"),
					    		new Ex08_Friend("���浿", "010-7777-7777", "04-28"),
						    	new Ex08_Friend("��浿", "010-9999-9999", "03-28") };
		/* ����ڷκ��� �˻��� ��ȭ��ȣ  ���ڸ��� �Է¹޾� => �ý������κ��� ���� ��¥�� �޾� "MM-dd" ��Ÿ���� string���� ��ȯ
		 * 0~������� �ش���ȭ��ȣ�� ������ ���		  => 0~������� �ش� ���ϰ� ������ ��ȯ�� ��Ʈ�� "03-28" ������ ���
		 * �˻��� ���� �ʾ� ��� ���ϸ� ���µ�! ��� ���  => �ش� �����ڰ� ���� ����� ���ϸ� ���µ�! ���
		 */
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd"); //MM-dd��Ÿ�Ϸ� ����ȯ
		String todayStr = sdf.format(today);
		System.out.println(todayStr); // String���� ��ȯ
		
		boolean searchOk = false; // ������ ������ ģ���� �ִ��� Ȯ��. ã���� true�� �ٲ�� �ɷ�
		for(Ex08_Friend friend : friends) {
			String birthday = friend.getBirthday(); // �ش��°�� ��ü ���ϰ� get
			if(birthday.equals(todayStr)){
				System.out.println(friend);
				searchOk = true;
			} // if- �������̸� ���
		} // for
		if(!searchOk) {
			System.out.println("���� �������� ģ���� �����ϴ�.");
		}
		
	}

}
