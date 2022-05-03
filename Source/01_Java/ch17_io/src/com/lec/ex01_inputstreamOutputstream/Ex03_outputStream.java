package com.lec.ex01_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// ���
// 1. ������ ����. (��¿� ��Ʈ�� ��ü ����)
// 2. write�Ѵ�. ���������δ� 1byte��
// 3. ������ �ݴ´�. (��Ʈ����ü.close())
public class Ex03_outputStream {

	public static void main(String[] args) {
		
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); 
			// 1. ���Ͽ��� true�� �ۼ��ϸ� ����Ⱑ �ȴ�.(�߰����ȴ�) - java8���� ����
			// ���ϸ� �ȿ� �������� �ʴ� ���ϸ��� �����ָ� ���ο� ������ �����ǰ�, �ִ� ���ϸ��� �����ָ� ����Ⱑ �ȴ�.
			byte[] bs = {'H', 'e', 'l', 'l', 'o', '1'};
//			for(int i=0; i<bs.length; i++) { // 2�ܰ� write
//				os.write(bs[i]);
//			}
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
		}
		// ������ ���� �� 'F5'Ű�� �Է��ϸ� ���� ���ΰ�ħ

	}

}
