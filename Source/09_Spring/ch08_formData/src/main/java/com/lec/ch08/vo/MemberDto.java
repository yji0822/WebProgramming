package com.lec.ch08.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 폼데이터에 입력받기 위해서 매개변수 없는 생성자
@Data // getter
public class MemberDto {
	private String name;
	private String id;
	private String pw;
	private int age;
	private String email;
	private String address;
	
	// 폼데이터 사용을 위하여 : getter, 매개변수 없는 생성자 사용을 위해
}
