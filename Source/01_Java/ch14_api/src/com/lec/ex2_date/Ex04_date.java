package com.lec.ex2_date;

import java.util.Calendar;
import java.util.Date;

public class Ex04_date {
	
	public static void main(String[] args) {
		Date date = new Date(); // 1991�̸� 91�� �����Ѵ�.
		System.out.println(date); // ���� �ӻ��ϰ� ����...�� (������ ����)
		
		int year = date.getYear(); // ����
		int month = date.getMonth(); // ��(Calendar.Month) 0,1,2,3,,,,11�� 1���� 0��..����
		int day   = date.getDate(); // ��
		// ���شٰ� ����� �Լ����̶� ���°� �����ؾ� ��
		
		// %d(����) %f(�Ǽ�) %s(���ڿ�) %c(����)
		// %tY(��) %tm(��) %td(��) %tH(24��) %tl(12��)
		System.out.printf("%tY�� %tm�� %td�� \n", year, month, day);
		// %d(����) %f(�Ǽ�) %s(���ڿ�) %c(����)
		// %tY(��) %tm(��) %td(��) %tH(24��) %tl(12��)
		System.out.printf("%tY�� %tm�� %td�� %ta���� %tp %tl�� %tM�� %tS��", date, date, date, date, date, date, date, date);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$ta���� %1$tp %1$tl�� %1$tM�� %1$tS��", date);
		
	}
}
