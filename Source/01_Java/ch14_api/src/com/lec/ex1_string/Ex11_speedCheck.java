package com.lec.ex1_string;
// String 수정(10만번) > StringBuffer 수정(10만번) > StringBuilder 수정(10만번) - 느린순서
public class Ex11_speedCheck {

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis()); //1970년1월1일부터 지금까지의 밀리세컨
		
		// String 변경 (10만번) - 시간체크
		String str = "A";
		long startTime = System.currentTimeMillis(); // 로직 시작 시점의 1970.01.01부터의 밀리세컨
		for(int i=0; i<100000; i++) { // 10만번 수정하는 로직
			str = str + "a";
		}
		long endTime = System.currentTimeMillis(); // 로직끝나는 시점의 1970.01.01부터의 밀리세컨
		System.out.println("String 10만번 수정 경과 시간 : " + (endTime-startTime));
		
		// StringBuffer - 10만번 으로 변경해서 시간 체크
		StringBuffer strBuf = new StringBuffer("A");
		startTime = System.currentTimeMillis();
		for(int i =0; i<100000; i++) {
			strBuf.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer 10만번 수정 경과 시간 : " + (endTime-startTime));
		
		// StringBuilder - 10만번 시간체크
		StringBuilder strBuld = new StringBuilder("A");
		startTime = System.currentTimeMillis();
		for(int i =0; i<100000; i++) {
			strBuld.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder 10만번 수정 경과 시간 : " + (endTime-startTime));
	}
	
}
