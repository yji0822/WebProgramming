package com.lec.ex01_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// ���
// 1. ������ ����. (��¿� ��Ʈ�� ��ü ����)
// 2. write�Ѵ�. ���������δ� 1byte��
// 3. ������ �ݴ´�. (��Ʈ����ü.close())
public class Ex04_outputStream {

	public static void main(String[] args) {
		
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt");
			// 1. ���Ͽ���
			String str = "Hello, java\n�� �ñ��� ��� �ǰ��ϼ���!"; // \n�̳� �ѱ� ��� ��� �����ϴ�
//			byte[] bs = {'H', 'e', 'l', 'l', 'o'}; // �����ϴ� �Ʒ� �������� �ٲ��� ��
			byte[] bs = str.getBytes(); // ��Ʈ���� byte�迭�� �ٲٴ� �Լ�
			os.write(bs);
			System.out.println("���� ��� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage()); // ������ ��θ� ã�� �� �����ϴ�. ��� // ������ ���� ��쿡 ������ �߻��ȴ�.
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(os != null) { // 3�ܰ� ������ �ݴ´�
				try {
					os.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		} // finally
		// ������ ���� �� 'F5'Ű�� �Է��ϸ� ���� ���ΰ�ħ

	}

}
