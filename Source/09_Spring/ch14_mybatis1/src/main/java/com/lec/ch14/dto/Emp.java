package com.lec.ch14.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp {
	
	// 주의! 필드 이름이랑 동일하게 만들어 주어야 한다!!!!!!!
	// 대문자랑 소문자 구분 안하는 데이터베이스
	private int empno;
	private String ename; 
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
}
