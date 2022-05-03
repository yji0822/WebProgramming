package com.lec.ex01_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1. ��Ʈ����ü(�Է¿�, ��¿�) 2. �а� ����. 3. ��Ʈ�� ��ü �ݴ´�(��Ʈ����ü.close())
// ���� ��������� ����Ѱ� �ݰ� ���� �ݴ� ������ ����!
public class Ex05_filecopyStep01 {

	public static void main(String[] args) {

		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("d:\\webPro\\spider.jpg"); // 1.
			os = new FileOutputStream("d:/webPro/spider_copy.png"); // true�ϸ� �ȵȴ�! �����ϴ� �ǵ� �߰��ϴ� ���� �ƴϱ� ����
			
			int cnt = 0; // while������ �󸶳� �о����� ����ϴ� ����
			while(true) { // 2.
				int i = is.read(); // 1byte�б�
				if(i == -1) break;
				os.write(i);
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
