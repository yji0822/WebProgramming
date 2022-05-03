package com.lec.ex8_decimalformat;

import java.text.DecimalFormat;

public class Ex {
	
	public static void main(String[] args) {
		
		double num = 1234567.89;
		num = 12300000000000L; // 1.23E13
		
		DecimalFormat df0 = new DecimalFormat("000000000"); // 0이 8개 - 8자리 출력
		System.out.println(df0.format(num)); // 001234568 - 자리수 0에 맞춰서 0도 모두 출력

		
		DecimalFormat df1 = new DecimalFormat("########"); // #이 8자리 : 8자리 출력
		System.out.println(df1.format(num)); // 1234568 - 반올림해서 있는 자리수만 출력
		
		DecimalFormat df2 = new DecimalFormat("0,000.000");
		System.out.println(df2.format(num));
		
		DecimalFormat df3 = new DecimalFormat("#,###.##%");
		System.out.println(df3.format(num));
		
		DecimalFormat df4 = new DecimalFormat("#.##E00");
		System.out.println(df4.format(num));
		
	}
}
