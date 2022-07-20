package com.lec.ch02.ex2_bmi;

import lombok.Data;

@Data
public class BMICalculator {
	private double lowWeight;
	private double normal;
	private double overWeight;
	private double obesity;
	
	// bmi지수 계산해주는 함수
	public void bmiCalculation(double weight, double height) {
		// 60 170
		// 계산법 - 60/(1.7*1.7)

		double h = height*0.01; // 1.7로 바꾸는 로직
		double result = weight / (h*h);
		System.out.println("BMI지수 : " + result);
		
		if(result > obesity) {
			System.out.println("비만");
		} else if(result > overWeight) {
			System.out.println("과체중");
		} else if(result > normal) {
			System.out.println("정상체중");
		} else if(result > lowWeight) {
			System.out.println("저체중");
		} else {
			System.out.println("심각");
		}
	}
}
