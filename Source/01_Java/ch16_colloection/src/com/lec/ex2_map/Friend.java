package com.lec.ex2_map;
import java.text.SimpleDateFormat;
// 4.학습예제 - Ex02_FreindMap.java
// Friend f = new Friend("홍", "010-9999-9999");
// sysout(f) = 홍의 연락처 010-9999-9999, 생일; 04월 14일 -> toString()
import java.util.Date;

public class Friend {

	// 데이터
	private String name; // 이름
	private String tel; // 전화번호
	private Date   birth; // 생일
	
	// 생성자
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public Friend(String name, String tel, Date birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	
	// 메소드
	// sysout(f) = 홍의 연락처 010-9999-9999, 생일; 04월 14일 -> toString()
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat(" 생일: MM월 dd일"); // 원하는 포맷으로 출력
		if(birth != null) {
			return name + "의 연락처 : " + tel + sdf.format(birth);
		} else {
			return name + "의 연락처 : " + tel;
		} // if-else
	} // toString()
	
	
}
