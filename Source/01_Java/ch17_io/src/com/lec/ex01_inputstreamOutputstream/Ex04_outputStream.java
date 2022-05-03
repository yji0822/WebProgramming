package com.lec.ex01_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// 출력
// 1. 파일을 연다. (출력용 스트림 객체 생성)
// 2. write한다. 공식적으로는 1byte씩
// 3. 파일을 닫는다. (스트림객체.close())
public class Ex04_outputStream {

	public static void main(String[] args) {
		
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt");
			// 1. 파일열기
			String str = "Hello, java\n이 시국에 모두 건강하세요!"; // \n이나 한글 모두 사용 가능하다
//			byte[] bs = {'H', 'e', 'l', 'l', 'o'}; // 불편하니 아래 형식으로 바꿔줄 것
			byte[] bs = str.getBytes(); // 스트링을 byte배열로 바꾸는 함수
			os.write(bs);
			System.out.println("파일 출력 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage()); // 지정된 경로를 찾을 수 없습니다. 출력 // 폴더가 없을 경우에 에러가 발생된다.
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(os != null) { // 3단계 파일을 닫는다
				try {
					os.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		} // finally
		// 폴더를 누른 후 'F5'키를 입력하면 폴더 새로고침

	}

}
