package com.lec.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter 생성
@AllArgsConstructor// 매개변수 있는 생성wk
@NoArgsConstructor

public class Member {
	
	private String id;
	private String pw;
	
	
	// 어노테이션이 있어도 내가 원하는 것을 선택해서 다시 만들 수 있다. > 다음은 컨트롤러 만들기
	@Override
	public String toString() {
		return "Member [아이디는 = " + id + ", 비밀번호는 " + pw + "]";
	}
	
	
}
