package com.lec.ch02.ex1_cal;

import lombok.Data;

@Data // getter setter toString
public class MyCalculator {
	
	private Calculator calculator; // MyCalcurator가 Calculator를 의존한다.
	private int num1;
	private int num2;
	
	public void add() {
		calculator.addition(num1, num2);
	}
	public void sub() {
		calculator.subtraction(num1, num2);
	}
	public void mul() {
		calculator.multiplication(num1, num2);
	}
	public void div() {
		calculator.division(num1, num2);
	}
	
	// Calculator class를 의존받아서 새로운 함수를 생성해주고 새로운 함수를 main에서 받아서 사용하도록
}
