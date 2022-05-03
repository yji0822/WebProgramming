package com.lec.ex04_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.io.PrintWriter;

public class Ex {

	public static void main(String[] args) {
		
		OutputStream os = null;
		Writer       writer = null;
		PrintWriter  printWriter = null;
		// ��� ��� ���� 
		
		try {
//			os = new FileOutputStream("txtFile/outTest.txt", true); // �⺻ ��Ʈ��
//			printWriter = new PrintWriter(os); // ���� ��Ʈ������ �뵵
			
//			writer = new FileWriter("txtFile/outTest.txt", true); // �⺻��Ʈ��
//			printWriter = new PrintWriter(writer); // ������Ʈ��
			
			printWriter = new PrintWriter("txtFile/outTest.txt"); // �⺻��Ʈ�� - append �Ұ�
			
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�.");
			printWriter.println("�ȳ��ϼ���\n�ݰ����ϴ�.");
			
			System.out.print("print�� �ڵ������� �ȵǼ� �����߰� \n");
			printWriter.print("print�� �ڵ������� �ȵǼ� �����߰�\n");
			
			System.out.printf("%s \t %d \t %d \t %5.1f\n", "ȫ�浿", 90, 91, 90.5);
			printWriter.printf("%s \t %d \t %d \t %5.1f\n", "ȫ�浿", 90, 91, 90.5);
			
			System.out.printf("%s \t %d \t %d \t %5.1f\n", "�ű浿", 100, 100, 100.0);
			printWriter.printf("%s \t %d \t %d \t %5.1f\n", "�ű浿", 100, 100, 100.0);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally { // try-catch ���ص� �ȴ�
			if(printWriter != null) {
				printWriter.close();
			}
		}
		
	}

}
