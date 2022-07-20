package com.lec.ch02.ex2_bmi;

import java.util.ArrayList;

import lombok.Data;

@Data
public class MyInfo { // main에서 사용할 클래스
	
	// 이름, 키, 몸무게, 취미, bmi계산한 값
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobby;
	private BMICalculator bmiCalculator; // @Data 만들어주고 getter,setter
	
	private void bmiCal() {
		bmiCalculator.bmiCalculation(weight, height);
	}
	
	public void getInfo() {
		// information 출력 - 외부에서 만들어져 있는것을 출력할 것.
		System.out.println("이름 : " + name);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("취미 : " + hobby); // 취미는 여러개일 수 있다. - ArrayList
		bmiCal(); // bmi지수 계산 및 결과 출력
	}
}
