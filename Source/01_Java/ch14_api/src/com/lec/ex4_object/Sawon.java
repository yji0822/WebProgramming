package com.lec.ex4_object;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

//Sawon s1 = new Sawon("a01", "홍길동", "COMPUTER"... or Dept.COMPUTER"); // 오늘이 입사일
//Sawon s1 = new Sawon("a02", "신길동", Dept.HUMANRESOURCES, 2022, 3, 24); // 3월24일 입사일
// sysout(s1) => [사번]a01 [이름]홍길동 [부서]COMPUTER [입사일}2022년3월24일(목)
public class Sawon {
	
	// 데이터
	public static final String COMPUTER = "COMPUTER";
	private String num; // 사번
	private String name; // 이름
	private String dept; // 부서
	private Date   hiredate ; // 입사일
	
	// 생성자
	public Sawon(String num, String name, String dept) {
		this.num = num;
		this.name = name;
		this.dept = dept;
		hiredate  = new Date(); // 입사일을 지금으로 설정.
	}
	public Sawon(String num, String name, String dept, int y, int m, int d) {
		this.num = num;
		this.name = name;
		this.dept = dept;
		// hiredate = new Date(y-1900, m-1, d);
		hiredate  = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis()); // 입사일을 입력한 날짜인 y년m월d일로 지정
	}
	
	// 출력하는 함수 오버라이드
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일 (E)"); // M월 3월, MM월 03월 / d일 3일, dd일 03일
	
		if(dept.length() <= 11) {
			return "[사번]" + num + "\t\t[이름]" + name + "\t[부서]" + dept +"\t\t[입사일]" + sdf.format(hiredate);
		} else {
		return "[사번]" + num + "\t\t[이름]" + name + "\t[부서]" + dept +"\t[입사일]" + sdf.format(hiredate);
		}
	}

}
