package com.lec.ch04.ex2;

import lombok.Data;

@Data // 2번째 방법 : 알아서 xml에서 지정을 해서 만들어질 수 있도록 하는 작업
public class AdminInfo {
	
	private String adminId;
	private String adminPw;
	private String subAdminId;
	private String subAdminPw;
	
}
