package com.lec.ex;

import java.sql.Date;

public class Member {
	
	private String id;
	private String pw;
	private Date   rdate; // 원하는 것을 추가하고 싶으면 추가해도 된다.
	
	// 빈태그를 사용하지 않으므로 디폴트 생성자를 만들어 주지 않아도 된다.
	public Member() {}
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
		rdate  = new Date(System.currentTimeMillis()) ; // 생성자가 호출되는 시점을 rdate에 넣어준다.
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	
	
}
