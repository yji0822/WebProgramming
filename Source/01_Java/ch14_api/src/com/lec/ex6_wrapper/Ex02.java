package com.lec.ex6_wrapper;

public class Ex02 {

	public static void main(String[] args) {

		double i = 10.1;
		double j = 10.1;
		double sum = i+j;
		System.out.println("합은 " + sum); 
		System.out.println(i==j ? "두 double는 같다." : "두 double는 다르다");
		
		Double iObj = new Double(10.1); // wrapper class
		Double jObj = 10.1; // new Double(10.1); 똑같은 말
		sum = iObj + jObj; // 알아서 자동으로 가져온다. sum = iObj.intValue() + jObj.intValue(); // 안에 있는 정수값을 가져오는 함수
		System.out.println("합은 " + sum);
		System.out.println(iObj.equals(j) ? "두 wrapper객체 값은 같다" : "두 wrapper 객체 값은 다르다"); // 기초데이터타입은 자동으로 변형되어서 들어가기 때문에 그냥 넣어주어도 된다.**
		System.out.println(iObj == jObj ? "같은 주소" : "다른 주소");
		
		
	}

}
