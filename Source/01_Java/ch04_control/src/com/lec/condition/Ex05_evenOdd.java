package com.lec.condition;

public class Ex05_evenOdd {

	public static void main(String[] args) {
		int num = -5;
		
		// if
		if(num%2 == 0) {
			System.out.println("Â¦");
		}
		else {
			System.out.println("È¦");
		}
		
		// switch-case
		switch(num%2) {
		case 0: 
			System.out.println("Â¦");
			break;
		default:
			System.out.println("È¦");
		}
			
		// »ïÇ×¿¬»êÀÚ **
		System.out.print(num%2==0 ? "Â¦" : "È¦");
		

	}

}
