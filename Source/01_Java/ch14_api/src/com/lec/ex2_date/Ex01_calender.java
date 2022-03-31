package com.lec.ex2_date;

import java.util.Calendar;

public class Ex01_calender {

	public static void main(String[] args) {
		// 지금 언제요. 그날. 
		
		Calendar cal = Calendar.getInstance(); // 싱글톤 클래스 - 한클래스 당 하나의 객체
		System.out.println(cal); // 완전 ㅣ상하게 나옴...흑 (가독성 저하)
		// java.util.GregorianCalendar[time=1648451774357,
		// areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",
		// offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,
		// minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=2,WEEK_OF_YEAR=14,WEEK_OF_MONTH=5,DAY_OF_MONTH=28,
		// DAY_OF_YEAR=87,DAY_OF_WEEK=2,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=16,
		// SECOND=14,MILLISECOND=357,ZONE_OFFSET=32400000,DST_OFFSET=0] - 가독성 떨어지는 실행결과
		
		int year = cal.get(Calendar.YEAR); // 연도
		int month = cal.get(Calendar.MONTH); // 월(Calendar.Month) 0,1,2,3,,,,11월 1월이 0월..ㅋㅋ
		int day   = cal.get(Calendar.DAY_OF_MONTH); // 일
		int week  = cal.get(Calendar.DAY_OF_WEEK);  // 일1, 월2, 화3, 수4.... 토7
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 24시간 기준
		int ampm = cal.get(Calendar.AM_PM); // 0(오전) 1(오후)
		int hour = cal.get(Calendar.HOUR); // 12시간 단위
		int minute = cal.get(Calendar.MINUTE); // 분
		int second = cal.get(Calendar.SECOND); // 초
		int millisec = cal.get(Calendar.MILLISECOND); // 밀리세컨
		
		// 출력
		System.out.printf("%d년 %d월 %d일 ", year, month, day);
		switch(week) {
		case 1: 
			System.out.print("월요일");
			break;
		case 2: 
			System.out.print("화요일");
			break;
		case 3: 
			System.out.print("수요일");
			break;
		case 4: 
			System.out.print("목요일");
			break;
		case 5: 
			System.out.print("금요일");
			break;
		case 6: 
			System.out.print("토요일");
			break;
		case 7: 
			System.out.print("일요일");
			break;
		}
		System.out.print(ampm == 0 ? " 오전" : " 오후");
		System.out.printf(" %d시 %d분 %d초 %d", hour, minute, second, millisec);
		System.out.printf(" / %d시 %d분 %d초 %d \n", hour24, minute, second, millisec);
		// 1000초가 1초! millisec
		
		// %d(정수) %f(실수) %s(문자열) %c(문자)
		// %tY(년) %tm(월) %td(일) %tH(24시) %tl(12시)
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tp %tl시 %tM분 %tS초", cal, cal, cal, cal, cal, cal, cal, cal);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tp %1$tl시 %1$tM분 %1$tS초", cal);

	}

}
