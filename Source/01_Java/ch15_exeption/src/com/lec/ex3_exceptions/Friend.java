package com.lec.ex3_exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

// Friend f = new Friend("ȫ�浿", "010-9999-9999");
// Friend f = new Friend("ȫ�浿");
// sysout(f) -> [�̸�] ȫ�浿 [��ȭ] ***-****-9999 [�Է���] 22��4��1��
public class Friend {
	
	private String name;
	private String tel;
	private Date enterDate;
	
	// ������
	public Friend(String name) {
		this.name = name;
		enterDate= new Date();
	}

	public Friend(String name, String tel) {
		this.name = name;
		this.tel  = tel;
		enterDate = new Date();
	}
	
	@Override
	public String toString() {
		String telPost;
		if(tel != null) {
			String post = tel.substring(tel.lastIndexOf('-')+1); //**��ȭ��ȣ �� 4�ڸ��� �޾ƿ��� �� ���� (10��°���� ������ �����ϴ°�)
			telPost = "***-****-" + post;
		} else {
			telPost = "��ȣ ���� \t";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yy�� M�� d�� ģ�� ��"); // m�� ��! M�� ��!
//		return "[�̸�] " + name + "\t[��ȭ] + telPost + "\t[�Է���] " + sdf.format(enterDate);
		return String.format("[�̸�] %s\t [��ȭ] %s\t[�Է���] %s", name, telPost, sdf.format(enterDate));
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	
	
	
	
	
}
