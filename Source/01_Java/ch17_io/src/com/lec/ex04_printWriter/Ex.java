package com.lec.ex04_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.io.PrintWriter;

public class Ex {

	public static void main(String[] args) {
		
		OutputStream os = null;
		Writer       writer = null;
		PrintWriter  printWriter = null;
		// 모두 사용 가능 
		
		try {
//			os = new FileOutputStream("txtFile/outTest.txt", true); // 기본 스트림
//			printWriter = new PrintWriter(os); // 보조 스트림으로 용도
			
//			writer = new FileWriter("txtFile/outTest.txt", true); // 기본스트림
//			printWriter = new PrintWriter(writer); // 보조스트림
			
			printWriter = new PrintWriter("txtFile/outTest.txt"); // 기본스트림 - append 불가
			
			System.out.println("안녕하세요\n반갑습니다.");
			printWriter.println("안녕하세요\n반갑습니다.");
			
			System.out.print("print는 자동개행이 안되서 개행추가 \n");
			printWriter.print("print는 자동개행이 안되서 개행추가\n");
			
			System.out.printf("%s \t %d \t %d \t %5.1f\n", "홍길동", 90, 91, 90.5);
			printWriter.printf("%s \t %d \t %d \t %5.1f\n", "홍길동", 90, 91, 90.5);
			
			System.out.printf("%s \t %d \t %d \t %5.1f\n", "신길동", 100, 100, 100.0);
			printWriter.printf("%s \t %d \t %d \t %5.1f\n", "신길동", 100, 100, 100.0);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally { // try-catch 안해도 된다
			if(printWriter != null) {
				printWriter.close();
			}
		}
		
	}

}
