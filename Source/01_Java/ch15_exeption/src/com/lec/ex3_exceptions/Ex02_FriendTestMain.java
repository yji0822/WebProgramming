package com.lec.ex3_exceptions;

import java.util.Date;

public class Ex02_FriendTestMain {

	public static void main(String[] args) {
		
		Friend hong = new Friend("ȫ�浿", "010-9999-9999");
		hong.setEnterDate(new Date(122, 2, 11));
		System.out.println(hong);
		
		Friend kim = new Friend("�赿��");
		System.out.println(kim);

	}

}
