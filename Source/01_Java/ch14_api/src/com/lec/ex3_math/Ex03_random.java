package com.lec.ex3_math;

import java.util.Random;

public class Ex03_random {

	public static void main(String[] args) {
		
		System.out.println("double 난수                      : " + Math.random()); // static method 0~1 사이의 랜덤 숫자 출력
		System.out.println("0~45 미만의 double 난수 : " + Math.random()*45); // static method 0~1 사이의 랜덤 숫자 출력
		/* 0 <= Math.random() < 1
		 * 0 <= Math.random()*45 < 45
		 * 0~44까지 정수 난수 : (int)(Math.random()*45)
		 */
		System.out.println("0~45 미만의 정수 난수          : " + (int)(Math.random()*45)); // 형변환 괄호 주의! - 괄호를 잘못해주면 무조건 0이 출력되어 버린다.
		System.out.println("로또 번호 뽑기(1~45)     : " + (int)(Math.random()*45)+1 + " 괄호 안해줘서 오류"); // 34까지만 랜덤으로 잡고 +1은 따로 잡아줘 버리게 된다. 
		System.out.println("로또 번호 뽑기(1~45)     : " + ((int)(Math.random()*45)+1)); // 반드시 괄호로 묶어줘라!
		
		System.out.println("\n 랜덤함수");
		Random random = new Random(); // 랜덤함수
		System.out.println("int 난수                  : " + random.nextInt()); // -부터 +21억까지 난수발생
		System.out.println("double 난수           : " + random.nextDouble()); // == Math.random() 반드시 객체를 생성해서 불러줘야 한다.
		System.out.println("T/F 중 하나의 난수    : " + random.nextBoolean()); // true or false
		System.out.println("0~2 사이의 정수 난수 : " + random.nextInt(3)); // 0~3 미만의 int형 난수 발생
		System.out.println("로또 번호 뽑기             : " + (random.nextInt(45)+1)); // Math.random()과 동일하게 괄호를 반드시 쳐주어야 한다!
		
	}

}
