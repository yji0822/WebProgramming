package com.lec.ex3_exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

// Friend f = new Friend("홍길동", "010-9999-9999");
// Friend f = new Friend("홍길동");
// sysout(f) -> [이름] 홍길동 [전화] ***-****-9999 [입력일] 22년4월1일
public class Friend {
	
	private String name;
	private String tel;
	private Date enterDate;
	
	// 생성자
	public Friend(String name) {
		this.name = name;
		enterDate= new Date();
	}

	public Friend(String name, String tel) {
		this.name = name;
		this.tel  = tel;
		enterDate = new Date();
	}
	
	@Override
	public String toString() {
		String telPost;
		if(tel != null) {
			String post = tel.substring(tel.lastIndexOf('-')+1); //**전화번호 끝 4자리만 받아오는 것 구현 (10번째부터 끝까지 구현하는것)
			telPost = "***-****-" + post;
		} else {
			telPost = "번호 없음 \t";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 M월 d일 친구 됨"); // m은 분! M은 월!
//		return "[이름] " + name + "\t[전화] + telPost + "\t[입력일] " + sdf.format(enterDate);
		return String.format("[이름] %s\t [전화] %s\t[입력일] %s", name, telPost, sdf.format(enterDate));
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	
	
	
	
	
}
