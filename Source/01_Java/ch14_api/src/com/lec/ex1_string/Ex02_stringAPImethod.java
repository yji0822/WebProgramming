package com.lec.ex1_string;

public class Ex02_stringAPImethod {

	public static void main(String[] args) {
		
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "    ja    va     ";
		
		System.out.println("1. " + str1.concat(str2)); 
		// 1. abcXabcABCXabc - String 두개를 더하는 메소드 (컨캣한다)
		System.out.println("2. " + str1.substring(3)); // 2. Xabc - 3번째 인덱스부터 끝까지 출력
		System.out.println("3. " + str1.substring(3, 5)); // 3. Xa - 3번째부터 5번째 앞까지
		
		System.out.println("4. " + str1.length()); // 4. 7 - 글자길이
		
		System.out.println("5. " + str1.toUpperCase()); // 5. ABCXABC - 대문자로
		System.out.println("6. " + str1.toLowerCase()); // 6. abcxabc - 소문자
		System.out.println("7. " + str1.charAt(3)); // 7. X - 3번째 문자 반환
		
		System.out.println("8. " + str1.indexOf('b')); 
		// 8. 1 - 첫번째 b문자가 나오는 인덱스 위치(시작 숫자 0)
		System.out.println("9. " + str1.indexOf('b', 3)); 
		// 9. 5 - 3번째부터 검색해서 나오는 첫번째 'b'의 인덱스 위치
		System.out.println("10. " + str1.indexOf("abc"));
		// 10. 0 - 첫번째 abc가 나오는 위치
		System.out.println("11. " + str1.indexOf("abc",3));
		// 11. 4 - 3번째부터 검색해서 나오는 "abc"위치
		// 12. -1 - 찾는 글자가 없으면 -1을 반환한다.
		System.out.println("12. " + str1.indexOf('z'));
		System.out.println("13. " + str1.lastIndexOf('b'));
		// 13. 5 - 마지막 b의 위치 전화번호 쓸 때 많이 사용
		System.out.println("14. " + str1.lastIndexOf('b', 3));
		// 14. 1 - 3번째부터 맨 마지막 b
		
		str1 = "abcXabc";
		str2 = new String("ABCXabc");
		str3 = "    ja    va     ";
		
		System.out.println("15. " + str1.equals(str2));
		// 15. false str1과 str2가 같은 문자열인지 확인
		System.out.println("16. " + str1.equalsIgnoreCase(str2)); // 16. true - 대소문자구분없이 비교  **
		System.out.println("17. " + str3.trim()); // 17. ja    va - 앞 뒤 공백제거 (중간 공백제거하는건 안됨)
		System.out.println("18. " + str1.replace('a', '9')); // 18. 9bcX9bc - 모든 'a'를 '9'로 수정한다
		System.out.println("19. " + str1.replace("abc", "#")); //19. #X# - 여러문자를 한꺼번에 변경도 가능
		System.out.println("20. " + str3.replace(" " , "")); // 20, java - 공백 모두 제거!
		System.out.println("21-1. " + str1.replaceAll("abc", "Z")); // "abc"을 "Z"로
		System.out.println("21-2. " + str1.replace("abc", "Z")); // "abc"을 "Z"로
		
		// 정규 표현식
		String str = "안녕Hello"; //한글이나 영어 둘 중 하나를 모두 지우고 싶을때
		// 영문자를 모두 *로 바꾸거나...
		System.out.println(str.replaceAll("[a-zA-Z]", "")); 
		// 알파벳을 ""로 수정하는.. 알파벳 소문자와 대문자... 시작과 끝을 적어준 것.
		System.out.println(str.replaceAll("[가-힣]", ""));
		// 한글은 시작이 가고 마지막이 힣임.
		// 문자열 메소드는 문자열을 수정하지 않음.
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
		// 출력된 것을 보면 처음 넣어두었던 문자열들이 바뀐 것은 아니다. 그냥 수정해서 출력한 것.
	} 
}
