package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05_SimpleDateFormant {

	public static void main(String[] args) {
		
		Date now1 	  		   = new Date();
		Calendar now2 		   = Calendar.getInstance();
		GregorianCalendar now3 = new GregorianCalendar();
		
		System.out.println(now1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a hh�� mm�� ss��");
		// ��¥�� �����͸� ���� ���ϴ� format���� ������ִ� ��
		/* yyyy(�⵵4�ڸ�) yy(�⵵2�ڸ�) M(3) MM(03) d(9) dd(09)
		 * E(����) a(����/����) H(24�ð�) h(12�ð�) m(��) s(��)
		 * w(�̹��⵵�� ���° ���Τ���) D(���ظ��°������)
		 */
		System.out.println(sdf.format(now1));
		System.out.println(sdf.format(now2.getTime()));
		System.out.println(sdf.format(now3.getTime()));
	}

}
