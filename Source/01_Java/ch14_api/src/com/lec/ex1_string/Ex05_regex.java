package com.lec.ex1_string;

public class Ex05_regex {
	public static void main(String[] args) {
		String str = "010-9999-9999 yisy0703@naver.com (02)565-8888 반갑습니다. Hello 951212-2521251  010-7777-8888  abc@hong.co.kr";
//		System.out.println("replace => " + str.replace("0", "홍")); // 특정문자열만 변경 가능 - 0만 홍으로
//		System.out.println(str.replace("010-8888-8888", newChar)); - 불가
		// 정규표현식 
		// 특정한 규칙을 갖고 있는..!
		/* 정규표현식(regex)
		 * 1. 참고 : https://goo.gl/HLntbd
		 * 2. 간략 문법 
		 * 		\d - (숫자와 매치, [0-9] 와 동일) \D - 숫자가 아닌 것
		 * 		\s - (whitespacen : space, 탭, 엔터)
		 * 		\w - (영문자나 숫자, [a-zA-Z0-9]와 동일) \W - 영문자나 숫자가 아닌문자
		 * 		. - (문자하나)
		 * 		+ - 1번 이상 반복
		 * 		* - 0번 이상 반복
		 * 		? - 0~1번 반복
		 * 		{2,3} {2,4} - 2~3회 반복, 2~4회 반복
		 * 3. 정규표현식 연습장 - 구글링
		 * https://www.regexpal.com/
		 * regexr.com
		 * ex) 전화번호 : [(]?[0-9]{2,3}\D[0-9]{3,4}-[0-9]{4}
		 * 	       이메일 : \w+@\w+(.\w+){1,2}
		 * 4. 특정 정규표현식의 문자열 변경 : (전화번호를 싹 다 변경하고 싶은 경우) replaceAll("정규표현식", "대체문자열") 내가 바꾸고 싶은 문자열(대체문자)
		 */
		
//		System.out.println(str.replaceAll("[0-9]", "X"));
//		System.out.println(str.replaceAll("\\d", "X")); // \n \t처럼 특별한 기능이 있는줄 알고 인식해서 오류가 뜨기 때문에 \를 문자로 쓰고 싶으면 한번 더 적어준다
//		System.out.println(str.replaceAll("\\D", "** 전화번호 지움 **"));
		// * 전화번호 지움
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}", "**전화번호 지움 **"));
		System.out.println();
		// 이메일 지움
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "==이메일삭제=="));
		System.out.println();
		// 알파벳 대신 *로 대체
		System.out.println("알파벳 대신 *로 대체 : " + str.replaceAll("[a-zA-Z]", "*"));
		// 한글 싹 다 없애기
		System.out.println("한글삭제 : " + str.replaceAll("[가-힣ㄱ-ㅎ]", "#"));
		// 주민번호 뒷자리를 *로 대체
		System.out.println("주민번호 뒷자리 삭제 : " + str.replaceAll("[0-9]{7}", "*******")); // 7번반복한다. - 주민번호
		
		
	}
}
