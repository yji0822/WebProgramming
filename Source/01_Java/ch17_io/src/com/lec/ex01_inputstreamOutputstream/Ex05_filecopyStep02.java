package com.lec.ex01_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// 1KByte�� ����ϴ� ����
// 1. ��Ʈ����ü(�Է¿�, ��¿�) 2. �а� ����. 3. ��Ʈ�� ��ü �ݴ´�(��Ʈ����ü.close())
// ���� ��������� ����Ѱ� �ݰ� ���� �ݴ� ������ ����!
public class Ex05_filecopyStep02 {

	public static void main(String[] args) {

		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("d:\\webPro\\bts.png"); // 1.
			os = new FileOutputStream("d:/webPro/bts_copy1.png"); // true�ϸ� �ȵȴ�! �����ϴ� �ǵ� �߰��ϴ� ���� �ƴϱ� ����
			
			int cnt = 0; // while������ �󸶳� �о����� ����ϴ� ����
			byte[] bs = new byte[1024]; // 1Kbyte��ŭ�� �о�� ����
			while(true) { // 2.
				int readByteCount = is.read(bs); // 1kbyte �б�
				if(readByteCount == -1) break; // ������ ������ Ȯ�� ����
				os.write(bs, 0, readByteCount); // bs�� 0�� �ε������� readByteCount��ŭ ����.
				cnt++;
			}
			System.out.println(cnt +"�� while�� �����Ͽ� ����� ���� ����!");
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // ���� �ݵ�� �����ֱ�!!!!!!
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
