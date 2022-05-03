package com.lec.ex01_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. ������ ���� (Stream ��ü ����) - ��� ��� ������ ���ǻ� ������Ʈ �ȿ��� ���� ���� �ҷ��� ��.
// 2. �����͸� �д´�.
// 3. ������ �ݴ´�.(Stream ��ü�� ���ش�)
public class Ex01_InputStream {

	public static void main(String[] args) {
		
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. ������ ����.
			while(true) { // 2. �����͸� �о�´�.
				int i = is.read(); // read(); ���� �߰��ϱ� IOException / 1byte�� �б� - ���Ѻο� / byte�� �о���� ���̱� ������ int�� �޾ƿ� // H�ϳ� �޾ƿ���
				if(i == -1) // -1�� ������ ���̶�� �ǹ� (�ڵ尪) - .read()���� ������ ���� ���� -1���� �ϱ� ������  / �ƽ�Ű�ڵ� ���� -1�� ����.
					break; // while ����
				System.out.print((char)i + "(" + i + ")" ); // ����ȯ �� ��� (�ƽ�Ű�ڵ尪 ���)
 			}
			System.out.println("\n��");
		} catch (FileNotFoundException e) {
			System.out.println("������ �� ã�� ��� ���� : " + e.getMessage());
		} catch (IOException e) { // ��ӹ޴� ���迡 �ִ��� Ȯ���ϰ�(ctrl+t) ������ �ִ� Ŭ������ �ؿ� �����ش�!
			System.out.println("������ �� �д� ��� ���� : " + e.getMessage()); 
		} finally {
			// 3. ������ �ݴ´�. - ���ܰ� �߻��Ǿ �����.	
			try {
				if(is != null) {
					is.close(); // *** �߿�!!!!!
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		// InputStream�� �߻�Ŭ����. ���� Ŭ���� �̿��ϱ�.
		// ��ǻ�� �ȿ����� �ƽ�Ű�ڵ� ���� �о���� ��.

	}

}
