package com.lec.ex2_date;

import java.util.Calendar;

public class Ex01_calender {

	public static void main(String[] args) {
		// ���� ������. �׳�. 
		
		Calendar cal = Calendar.getInstance(); // �̱��� Ŭ���� - ��Ŭ���� �� �ϳ��� ��ü
		System.out.println(cal); // ���� �ӻ��ϰ� ����...�� (������ ����)
		// java.util.GregorianCalendar[time=1648451774357,
		// areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",
		// offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,
		// minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=2,WEEK_OF_YEAR=14,WEEK_OF_MONTH=5,DAY_OF_MONTH=28,
		// DAY_OF_YEAR=87,DAY_OF_WEEK=2,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=16,
		// SECOND=14,MILLISECOND=357,ZONE_OFFSET=32400000,DST_OFFSET=0] - ������ �������� ������
		
		int year = cal.get(Calendar.YEAR); // ����
		int month = cal.get(Calendar.MONTH); // ��(Calendar.Month) 0,1,2,3,,,,11�� 1���� 0��..����
		int day   = cal.get(Calendar.DAY_OF_MONTH); // ��
		int week  = cal.get(Calendar.DAY_OF_WEEK);  // ��1, ��2, ȭ3, ��4.... ��7
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 24�ð� ����
		int ampm = cal.get(Calendar.AM_PM); // 0(����) 1(����)
		int hour = cal.get(Calendar.HOUR); // 12�ð� ����
		int minute = cal.get(Calendar.MINUTE); // ��
		int second = cal.get(Calendar.SECOND); // ��
		int millisec = cal.get(Calendar.MILLISECOND); // �и�����
		
		// ���
		System.out.printf("%d�� %d�� %d�� ", year, month, day);
		switch(week) {
		case 1: 
			System.out.print("������");
			break;
		case 2: 
			System.out.print("ȭ����");
			break;
		case 3: 
			System.out.print("������");
			break;
		case 4: 
			System.out.print("�����");
			break;
		case 5: 
			System.out.print("�ݿ���");
			break;
		case 6: 
			System.out.print("�����");
			break;
		case 7: 
			System.out.print("�Ͽ���");
			break;
		}
		System.out.print(ampm == 0 ? " ����" : " ����");
		System.out.printf(" %d�� %d�� %d�� %d", hour, minute, second, millisec);
		System.out.printf(" / %d�� %d�� %d�� %d \n", hour24, minute, second, millisec);
		// 1000�ʰ� 1��! millisec
		
		// %d(����) %f(�Ǽ�) %s(���ڿ�) %c(����)
		// %tY(��) %tm(��) %td(��) %tH(24��) %tl(12��)
		System.out.printf("%tY�� %tm�� %td�� %ta���� %tp %tl�� %tM�� %tS��", cal, cal, cal, cal, cal, cal, cal, cal);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$ta���� %1$tp %1$tl�� %1$tM�� %1$tS��", cal);

	}

}
