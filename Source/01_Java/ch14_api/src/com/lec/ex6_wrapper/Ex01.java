package com.lec.ex6_wrapper;

import com.lec.ex4_object.Dept;
import com.lec.ex4_object.Sawon;

public class Ex01 {

	public static void main(String[] args) {

		int i = 10;
		int j = 10;
		int sum = i+j;
		System.out.println("합은 " + sum); 
		System.out.println(i==j ? "두 int는 같다." : "두 int는 다르다");
		
		Integer iObj = new Integer(10); // wrapper class
		Integer jObj = 10; // new Integer(10); 똑같은 말
		sum = iObj.intValue() + jObj.intValue(); // 안에 있는 정수값을 가져오는 함수
		System.out.println("합은 " + sum);
		System.out.println(iObj.equals(jObj) ? "두 wrapper객체 값은 같다" : "두 wrapper 객체 값은 다르다");
		System.out.println(iObj == jObj ? "같은 주소" : "다른 주소");
		
		Sawon s = new Sawon("a01", "홍길동", Dept.COMPUTER);
		if(s.equals(new Integer(10))) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
	}

}
