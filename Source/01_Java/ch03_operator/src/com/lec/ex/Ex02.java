package com.lec.ex;
// 증감연산 : ++	--
public class Ex02 {

	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; // 하나씩 증가 - n1도 증가되고 n2도 증가가 됨.
		System.out.println("n1 = " + n1 + "\t n2 = " + n2);
		
		n2 = ++n1; // 하나씩 증가 - n1도 증가되고 n2도 증가가 됨.
		System.out.println("n1 = " + n1 + "\t n2 = " + n2);

		n1 = 10;
		n2 = --n1; // 세미콜론이 있기 그 전에 감소
		System.out.println("n1 = " + n1 + "\t n2 = " + n2);
		
		n1 = 10;
		n2 = n1++;
		System.out.println("n1 = " + n1 + "\t n2 = " + n2);
		
		n1 = 10;
		n2 = n1--; // 세미콜론이 있는 시점에서 감소
		System.out.println("n1 = " + n1 + "\t n2 = " + n2);
		
		// 증감연산자는 앞에 붙이냐 뒤에 붙이냐에 따라 결과값이 다르게 나온다.	
		// 증감연산자 다시 보기...!
	
	}

}
