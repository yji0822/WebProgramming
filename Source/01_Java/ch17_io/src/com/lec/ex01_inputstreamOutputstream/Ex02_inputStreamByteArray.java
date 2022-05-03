package com.lec.ex01_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. 파일 연다 ; Stream객체 뽑는다.
// 2. 데이터를 연다 : read() 1byte씩 읽는다. 속도가 느리다. / read(byte[]) - byte[]배열씩 읽어온다.
// 3. 파일 닫는다 : Stream 객체 뺀다.
public class Ex02_inputStreamByteArray {

	public static void main(String[] args) {
		
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. 파일 연다
			byte[] bs = new byte[10]; // 10개의 byte읽어오는 배열[0~9]
			while(true) { // 2. 파일 읽는다.
				int readByteCount = is.read(bs); // 10byte씩 읽어오기
				if(readByteCount == -1) { // 파일의 끝인지 확인
					break; 
				}
				
				// 확장 FOR문을 작성할 경우 이상하게 출력.
				for(int i=0; i<readByteCount; i++) {
					System.out.print((char)bs[i]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 3. 파일 닫는다
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
