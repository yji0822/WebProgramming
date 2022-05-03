package com.lec.ex01_inputstreamOutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// ***절대기억하기**** filecopy ** 
// 1. 스트림객체(입력용, 출력용) 2. 읽고 쓴다. 3. 스트림 객체 닫는다(스트림객체.close())
// 열고 출력했으면 출력한거 닫고 연거 닫는 순서가 정석!
public class Ex05_filecopyStep03 {

	public static void main(String[] args) {

		InputStream is = null;
		OutputStream os = null;
		
		try {
			File file = new File("d:\\webPro\\bts.png"); // file객체 생성, import
			is = new FileInputStream(file); // 1. //  파일의 용량을 불러오는 함수
			os = new FileOutputStream("d:/webPro/bts_copy2.png"); // true하면 안된다! 복사하는 건데 추가하는 것이 아니기 때문
			
			int cnt = 0; // while문에서 얼마나 읽었는지 출력하는 변수
			byte[] bs = new byte[(int)file.length()]; // long형의 크기만큼 byte가 잡힌다(int로 형변환)
			while(true) { // 2.
				int readByteCount = is.read(bs); // 1kbyte 읽기
				if(readByteCount == -1) break; // 파일의 끝인지 확인 여부
				os.write(bs, 0, readByteCount); // bs를 0번 인덱스부터 readByteCount만큼 쓴다.
				cnt++;
			}
			System.out.println(cnt +"번 while문 실행하여 힘들게 복사 성공!");
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 순서 반드시 지켜주기!!!!!!
				if(os != null) {
					os.close();
				}
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} // catch
			
		} // finally
		
	} // main

}
