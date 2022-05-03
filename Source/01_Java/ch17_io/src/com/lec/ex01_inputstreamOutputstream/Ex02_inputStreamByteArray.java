package com.lec.ex01_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. ���� ���� ; Stream��ü �̴´�.
// 2. �����͸� ���� : read() 1byte�� �д´�. �ӵ��� ������. / read(byte[]) - byte[]�迭�� �о�´�.
// 3. ���� �ݴ´� : Stream ��ü ����.
public class Ex02_inputStreamByteArray {

	public static void main(String[] args) {
		
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. ���� ����
			byte[] bs = new byte[10]; // 10���� byte�о���� �迭[0~9]
			while(true) { // 2. ���� �д´�.
				int readByteCount = is.read(bs); // 10byte�� �о����
				if(readByteCount == -1) { // ������ ������ Ȯ��
					break; 
				}
				
				// Ȯ�� FOR���� �ۼ��� ��� �̻��ϰ� ���.
				for(int i=0; i<readByteCount; i++) {
					System.out.print((char)bs[i]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 3. ���� �ݴ´�
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
