package com.lec.condition;

public class Ex05_evenOdd {

	public static void main(String[] args) {
		int num = -5;
		
		// if
		if(num%2 == 0) {
			System.out.println("¦");
		}
		else {
			System.out.println("Ȧ");
		}
		
		// switch-case
		switch(num%2) {
		case 0: 
			System.out.println("¦");
			break;
		default:
			System.out.println("Ȧ");
		}
			
		// ���׿����� **
		System.out.print(num%2==0 ? "¦" : "Ȧ");
		

	}

}
