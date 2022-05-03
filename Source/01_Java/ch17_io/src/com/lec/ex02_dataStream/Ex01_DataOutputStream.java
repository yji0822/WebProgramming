package com.lec.ex02_dataStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// 1. 스트림 객체 생성 == 파일을 연다(메모장에 보이지 않게 작성)
// 2. 데이터 쓴다
// 3. 스트림 객체 닫는다 == 파일을 닫는다.
// 보안 파일 저장하기 위해서 사용하는 용도였다. 
public class Ex01_DataOutputStream {

	public static void main(String[] args) {
		
		OutputStream     fos = null; // 기본 데이터를 먼저 만들어 준다.
		DataOutputStream dos = null; // 반드시 기본 데이터와 같이 만들어준다.(보조스트림객체)
		
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat", true); // 기본 스트림 객체
			dos = new DataOutputStream(fos);  // 기본 스트림을 통해서만 만들 수 있는 보조 스트림
			// 이름-학년-점수 write
			dos.writeUTF("홍길동"); // String값 저장
			dos.writeInt(2); // int값 저장
			dos.writeDouble(95.5); // double값 저장
			
			dos.writeUTF("신길동"); // String값 저장
			dos.writeInt(3); // int값 저장
			dos.writeDouble(95.9); // double값 저장
			
			System.out.println("파일 저장 완료!"); // 자바 프로그램으로 밖에 보이지 않는다.
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos != null) dos.close();
				if(fos != null) fos.close();
			}catch(IOException e2){
				System.out.println(e2.getMessage());
			}
		}
		
		

	}

}
