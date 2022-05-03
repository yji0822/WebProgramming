package com.lec.ex02_dataStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 자바로 밖에 불러올 수 밖에 없다.
public class Ex02_DataInputStream {

	public static void main(String[] args) {
		
		InputStream     fis = null;
		DataInputStream dis = null;
	
		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(fis); // 보조스트림은 기본스트림을 통해서 생성
			
			while(true) { // write에서 쓴 순서대로 작성해주어야 한다.
				String name = dis.readUTF();
				int grade = dis.readInt();
				double score = dis.readDouble();
				System.out.printf("%s는 %d학년 %f점 \n", name, grade, score);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음." + e.getMessage());
		} catch (IOException e) {
			System.out.println("이상데이터 끝"); // 정상적인 것이어도 맨 마지막 부분이 이곳으로 빠지기 때문에 반드시 출력된다. 
		}finally {
				try {
					if(dis != null) {
					dis.close();
					}
					if(fis != null) fis.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} // try-catch
		} // finally
		

	}

}
