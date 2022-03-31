package com.lec.ex2_human;
// Man kim = new Man (22, 160, 50.2, "010-4444-5555"); - 생성자 4개 모두 초기화
// Man kim = new Man (22, 160, 50.2); - 생성자3개. 전화번호를 입력하지 않아도 되도록

public class Man {
	private int age; // 나이
	private int height; // 키 
	private double weight; // 몸무게
	private String phoneNum; // 핸드폰번호

	// 생성자
	public Man() {} // 디폴트 생성자 함수
	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		System.out.println("파라미터가 4개짜리 생성자 함수 호출");	
	}
	
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;	
		System.out.println("파라미터가 3개짜리 생성자 함수 호출");	
	}
	// 같은 값의 자료형은 따로 분리해서 생성자를 만들 수 없다.
	// 매개변수의 종류로 함수의 오버로딩을 분류하기 때문에!
	public Man(int age) {
		this.age = age;
	} // 내 객체 안에 있는 age
//	public Man(int height) {
//		this.height = height;
//	} // 사용불가
	
	// 메소드(함수)
	public double calculateBMI() {
		double result = weight / ((height/100.0) * (height/100.0));
		return result;
	} // BMI 계산해주는 메소드(함수)
	
	// setter&getter (age, height, weight, phoneNum)
	public void setAge(int age) {
		this.age = age; // this. - "내 객체 안의" 라는 의미 
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	// getter m.getAge() age가 뭐니? 하고 가져오는  m.setAge(22)
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
		
	
	
}
