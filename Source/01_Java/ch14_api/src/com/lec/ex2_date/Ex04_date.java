package com.lec.ex2_date;

import java.util.Calendar;
import java.util.Date;

public class Ex04_date {
	
	public static void main(String[] args) {
		Date date = new Date(); // 1991이면 91을 저장한다.
		System.out.println(date); // 완전 ㅣ상하게 나옴...흑 (가독성 저하)
		
		int year = date.getYear(); // 연도
		int month = date.getMonth(); // 월(Calendar.Month) 0,1,2,3,,,,11월 1월이 0월..ㅋㅋ
		int day   = date.getDate(); // 일
		// 없앤다고 얘기한 함수들이라 쓰는거 자제해야 함
		
		// %d(정수) %f(실수) %s(문자열) %c(문자)
		// %tY(년) %tm(월) %td(일) %tH(24시) %tl(12시)
		System.out.printf("%tY년 %tm월 %td일 \n", year, month, day);
		// %d(정수) %f(실수) %s(문자열) %c(문자)
		// %tY(년) %tm(월) %td(일) %tH(24시) %tl(12시)
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tp %tl시 %tM분 %tS초", date, date, date, date, date, date, date, date);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tp %1$tl시 %1$tM분 %1$tS초", date);
		
	}
}
