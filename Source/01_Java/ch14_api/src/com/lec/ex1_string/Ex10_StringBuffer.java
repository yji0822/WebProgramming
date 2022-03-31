package com.lec.ex1_string;

public class Ex10_StringBuffer {

	public static void main(String[] args) {
		
		String str = "abc";
		System.out.println(str.hashCode());
		str = str + "d";
		System.out.println(str.hashCode());
		
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("strBuilder = " +strBuilder);
		System.out.println(strBuilder.hashCode());
		
		// 2. 기존의 문자열에 추가
		strBuilder.append("def"); // 기존의 "abc"에 "def"를 추가 : abcdef
		System.out.println("strBuilder(문자열추가) = " +strBuilder);
		System.out.println(strBuilder.hashCode());
		
		// 3. 기존의 문자열 사이에 추가
		strBuilder.insert(3, "AAA"); // 3번째에 "AAA" 추가 (인덱스처럼 0부터 시작한다.) abcAAAdef
		System.out.println("strBuilder(문자열사이에 추가) = " + strBuilder);
		System.out.println(strBuilder.hashCode());
		
		// 4. 삭제
		strBuilder.delete(3, 5); // 3번째부터 5번째 앞까지 삭제 : abcAdef
		System.out.println("strBuilder(문자열 삭제) = " + strBuilder);
		System.out.println(strBuilder.hashCode());
		
		// 5. 인덱스 한글자 삭제
		strBuilder.deleteCharAt(3);
		System.out.println("strBuilder(몇번째 인덱스 삭제) = " + strBuilder);
		System.out.println(strBuilder.hashCode());
	
		
		
	}

}
