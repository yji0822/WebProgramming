package com.lec.ex03_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_writer {

	public static void main(String[] args) {
		
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt", true); // 1.
//			char[] msg = {'��', '��'};
			String msg = "\n\n �߰��� �ؽ�Ʈ �����Դϴ�. �ȳ��ϼ���!";
			writer.write(msg);
			System.out.println("������� ����");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer != null) {
					writer.close(); // 3. �ݱ�
				}
			} catch (Exception ignore) {} 
			// ������ catch �κ��� ����� ���ϱ� ������ ������ �Ϻη� ignore��� �����ϴ� ��쵵 �ִ�.
		}

	}

}
