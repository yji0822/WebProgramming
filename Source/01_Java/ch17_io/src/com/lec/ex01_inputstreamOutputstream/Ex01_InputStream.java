package com.lec.ex01_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. 파일을 연다 (Stream 객체 생성) - 어디서 열어도 되지만 편의상 프로젝트 안에서 폴더 만들어서 불러올 것.
// 2. 데이터를 읽는다.
// 3. 파일을 닫는다.(Stream 객체를 없앤다)
public class Ex01_InputStream {

	public static void main(String[] args) {
		
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. 파일을 연다.
			while(true) { // 2. 데이터를 읽어온다.
				int i = is.read(); // read(); 예외 추가하기 IOException / 1byte씩 읽기 - 권한부여 / byte로 읽어오는 것이기 때문에 int로 받아옴 // H하나 받아오고
				if(i == -1) // -1은 파일의 끝이라는 의미 (코드값) - .read()에서 파일의 끝을 가면 -1리턴 하기 때문에  / 아스키코드 값에 -1은 없다.
					break; // while 종료
				System.out.print((char)i + "(" + i + ")" ); // 형변환 후 출력 (아스키코드값 출력)
 			}
			System.out.println("\n끝");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 못 찾은 경우 예외 : " + e.getMessage());
		} catch (IOException e) { // 상속받는 관계에 있는지 확인하고(ctrl+t) 상위에 있는 클래스를 밑에 적어준다!
			System.out.println("파일을 못 읽는 경우 예외 : " + e.getMessage()); 
		} finally {
			// 3. 파일을 닫는다. - 예외가 발생되어도 실행됨.	
			try {
				if(is != null) {
					is.close(); // *** 중요!!!!!
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		// InputStream은 추상클래스. 하위 클래스 이용하기.
		// 컴퓨터 안에서는 아스키코드 값을 읽어오는 것.

	}

}
