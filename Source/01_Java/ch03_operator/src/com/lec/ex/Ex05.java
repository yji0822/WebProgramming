package com.lec.ex;
// 비트 연산자 & |
public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 3; 
		int j = 1; 
		// 0 0 1 1
        // 0 0 0 1
		// =======
		// 0 0 0 1
		System.out.println(i & j); // 1
		// =======
		// 0 0 1 1
		System.out.println(i | j); // 3

	}

}
