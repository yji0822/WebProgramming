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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		/* yyyy(년도4자리) yy(년도2자리) M(3) MM(03) d(9) dd(09)
		 * E(요일) a(오전/오후) H(24시간) h(12시간) m(분) s(초)
		 * w(이번년도에 몇번째 주인ㄴ지) D(올해몇번째날인지)
		 */
		System.out.println(sdf.format(now1));
		System.out.println(sdf.format(now2.getTime()));
		System.out.println(sdf.format(now3.getTime()));
	}

}
