package com.lec.ex01_inputstreamOutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// ***�������ϱ�**** filecopy ** 
// 1. ��Ʈ����ü(�Է¿�, ��¿�) 2. �а� ����. 3. ��Ʈ�� ��ü �ݴ´�(��Ʈ����ü.close())
// ���� ��������� ����Ѱ� �ݰ� ���� �ݴ� ������ ����!
public class Ex05_filecopyStep03 {

	public static void main(String[] args) {

		InputStream is = null;
		OutputStream os = null;
		
		try {
			File file = new File("d:\\webPro\\bts.png"); // file��ü ����, import
			is = new FileInputStream(file); // 1. //  ������ �뷮�� �ҷ����� �Լ�
			os = new FileOutputStream("d:/webPro/bts_copy2.png"); // true�ϸ� �ȵȴ�! �����ϴ� �ǵ� �߰��ϴ� ���� �ƴϱ� ����
			
			int cnt = 0; // while������ �󸶳� �о����� ����ϴ� ����
			byte[] bs = new byte[(int)file.length()]; // long���� ũ�⸸ŭ byte�� ������(int�� ����ȯ)
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
