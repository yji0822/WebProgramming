package com.lec.ex3_math;
// Math.ceil(올릴 실수값) => double값  return
// Math.round (반올림할 실수값) 9.5 > 10 => 정수값 return
// Math.floor (내릴 실수값) => double값 return
public class Ex02_round {

	public static void main(String[] args) {
		
		System.out.println("* 소수점에서 반올림, 올림, 버림 예제");
		System.out.println("9.15를 올림    : " + Math.ceil(9.15)); // double 반환
		System.out.println("9.15를 올림    : " + (int)Math.ceil(9.15)); // 소수점에서 올림
		System.out.println("9.15를 반올림 : " + Math.round(9.15));  // int 반환
		System.out.println("9.15를 내림    : " + Math.floor(9.15));
		System.out.println("9.15를 내림    : " + (int)Math.floor(9.15));
		
		// 소수점 몇번째 자리에서 반올림 하는 방법
		System.out.println("\n* 소수점 첫째자리에서 반올림, 올림, 버림 ");
		System.out.println("9.15를 올림                              : " + Math.ceil(9.15)); // java api에서는 소수점 올림 함수는 지원하지 않는다.
		System.out.println("9.15를 소수점 두번째에서 올림    : " + Math.ceil(9.15*10)/10);
		System.out.println("9.15를 반올림                           : " + Math.round(9.15));
		System.out.println("9.15를 소수점 두번째에서 반올림 : " + Math.round(9.15*10)/10.0); // round는 정수형을 리턴해주기때문에 10.0 으로 적어주어야 한다.
		System.out.println("9.15를 내림                              : " + Math.floor(9.15));
		System.out.println("9.15를 소수점 두번째에서 내림    : " + Math.floor(9.15*10)/10);
		
		// 일의 자리에서 반올림, 올림, 내림
		System.out.println("\n* 일의 자리에서 반올림, 올림, 내림");
		System.out.println("85를 올림    : " + Math.ceil(85/10.0)*10);
		System.out.println("85를 반올림 : " + Math.round(85/10.0)*10);
		System.out.println("85를 내림    : " + Math.floor(85/10.0)*10);
		
	}
	

}
