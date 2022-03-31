package com.lec.ex4_object;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

//Sawon s1 = new Sawon("a01", "ȫ�浿", "COMPUTER"... or Dept.COMPUTER"); // ������ �Ի���
//Sawon s1 = new Sawon("a02", "�ű浿", Dept.HUMANRESOURCES, 2022, 3, 24); // 3��24�� �Ի���
// sysout(s1) => [���]a01 [�̸�]ȫ�浿 [�μ�]COMPUTER [�Ի���}2022��3��24��(��)
public class Sawon {
	
	// ������
	public static final String COMPUTER = "COMPUTER";
	private String num; // ���
	private String name; // �̸�
	private String dept; // �μ�
	private Date   hiredate ; // �Ի���
	
	// ������
	public Sawon(String num, String name, String dept) {
		this.num = num;
		this.name = name;
		this.dept = dept;
		hiredate  = new Date(); // �Ի����� �������� ����.
	}
	public Sawon(String num, String name, String dept, int y, int m, int d) {
		this.num = num;
		this.name = name;
		this.dept = dept;
		// hiredate = new Date(y-1900, m-1, d);
		hiredate  = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis()); // �Ի����� �Է��� ��¥�� y��m��d�Ϸ� ����
	}
	
	// ����ϴ� �Լ� �������̵�
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� M�� d�� (E)"); // M�� 3��, MM�� 03�� / d�� 3��, dd�� 03��
	
		if(dept.length() <= 11) {
			return "[���]" + num + "\t\t[�̸�]" + name + "\t[�μ�]" + dept +"\t\t[�Ի���]" + sdf.format(hiredate);
		} else {
		return "[���]" + num + "\t\t[�̸�]" + name + "\t[�μ�]" + dept +"\t[�Ի���]" + sdf.format(hiredate);
		}
	}

}
