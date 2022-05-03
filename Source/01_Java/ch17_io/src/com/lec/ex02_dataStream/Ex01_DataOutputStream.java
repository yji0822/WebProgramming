package com.lec.ex02_dataStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// 1. ��Ʈ�� ��ü ���� == ������ ����(�޸��忡 ������ �ʰ� �ۼ�)
// 2. ������ ����
// 3. ��Ʈ�� ��ü �ݴ´� == ������ �ݴ´�.
// ���� ���� �����ϱ� ���ؼ� ����ϴ� �뵵����. 
public class Ex01_DataOutputStream {

	public static void main(String[] args) {
		
		OutputStream     fos = null; // �⺻ �����͸� ���� ����� �ش�.
		DataOutputStream dos = null; // �ݵ�� �⺻ �����Ϳ� ���� ������ش�.(������Ʈ����ü)
		
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat", true); // �⺻ ��Ʈ�� ��ü
			dos = new DataOutputStream(fos);  // �⺻ ��Ʈ���� ���ؼ��� ���� �� �ִ� ���� ��Ʈ��
			// �̸�-�г�-���� write
			dos.writeUTF("ȫ�浿"); // String�� ����
			dos.writeInt(2); // int�� ����
			dos.writeDouble(95.5); // double�� ����
			
			dos.writeUTF("�ű浿"); // String�� ����
			dos.writeInt(3); // int�� ����
			dos.writeDouble(95.9); // double�� ����
			
			System.out.println("���� ���� �Ϸ�!"); // �ڹ� ���α׷����� �ۿ� ������ �ʴ´�.
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos != null) dos.close();
				if(fos != null) fos.close();
			}catch(IOException e2){
				System.out.println(e2.getMessage());
			}
		}
		
		

	}

}
