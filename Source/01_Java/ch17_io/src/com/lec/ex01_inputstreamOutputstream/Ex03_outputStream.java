package com.lec.ex01_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// 출력
// 1. 파일을 연다. (출력용 스트림 객체 생성)
// 2. write한다. 공식적으로는 1byte씩
// 3. 파일을 닫는다. (스트림객체.close())
public class Ex03_outputStream {

	public static void main(String[] args) {
		
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); 
			// 1. 파일열기 true를 작성하면 덮어쓰기가 된다.(추가가된다) - java8사전 참고
			// 파일명 안에 존재하지 않는 파일명을 적어주면 새로운 파일이 생성되고, 있는 파일명을 적어주면 덮어쓰기가 된다.
			byte[] bs = {'H', 'e', 'l', 'l', 'o', '1'};
//			for(int i=0; i<bs.length; i++) { // 2단계 write
//				os.write(bs[i]);
//			}
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
		}
		// 폴더를 누른 후 'F5'키를 입력하면 폴더 새로고침

	}

}
