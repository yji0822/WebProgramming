package com.lec.ex01_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1. 스트림객체(입력용, 출력용) 2. 읽고 쓴다. 3. 스트림 객체 닫는다(스트림객체.close())
// 열고 출력했으면 출력한거 닫고 연거 닫는 순서가 정석!
public class Ex05_filecopyStep01 {

	public static void main(String[] args) {

		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("d:\\webPro\\spider.jpg"); // 1.
			os = new FileOutputStream("d:/webPro/spider_copy.png"); // true하면 안된다! 복사하는 건데 추가하는 것이 아니기 때문
			
			int cnt = 0; // while문에서 얼마나 읽었는지 출력하는 변수
			while(true) { // 2.
				int i = is.read(); // 1byte읽기
				if(i == -1) break;
				os.write(i);
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
