package com.lec.ex03_readerwriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {

	public static void main(String[] args) {

		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); // 1. ������ ����
			while(true) { // 2. �����͸� �д´�.
				int i = reader.read();
				if(i==-1) {
					break;
				}
				System.out.print((char)i);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} try {
				if(reader != null) {
				reader.close();
				} 
		} catch (IOException e2) {
					System.out.println(e2.getMessage());
					}
		
	}

}
