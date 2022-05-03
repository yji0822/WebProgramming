package com.lec.ex03_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_writer {

	public static void main(String[] args) {
		
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt", true); // 1.
//			char[] msg = {'안', '녕'};
			String msg = "\n\n 추가한 텍스트 파일입니다. 안녕하세요!";
			writer.write(msg);
			System.out.println("파일출력 성공");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer != null) {
					writer.close(); // 3. 닫기
				}
			} catch (Exception ignore) {} 
			// 마지막 catch 부분은 출력을 안하기 때문에 변수를 일부러 ignore라고 설정하는 경우도 있다.
		}

	}

}
