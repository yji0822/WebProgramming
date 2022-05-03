package com.lec.ex02_dataStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_ProductWriter { // ����Է� ���α׷� (����ڰ� 'n'�� �Է��ϱ� ������ ���� �ݺ�) -  ��ǰ��, ����, ����� �Է� �޾� ���� ���
//	���� ������ ���Ϸ� �Է� �޾Ƽ� ����� ���� 

	public static void main(String[] args) {
		// while�� ���� - �ѹ� �Է��ϸ� �����ϱⰡ �����.�� �ҷ����� ������ ��ǰ�� �θ� ���� ���� ���־�� �Ѵ�.
		Scanner sc = new Scanner (System.in);
		String answer; // y or n �Է¹޴� ����
		OutputStream fos     = null; // ��� �Է¹޴� ����
		DataOutputStream dos = null;
		try {
			// ���� ��Ű�� �ؿ� �ְ� ������(Ư���� �������)/ true�� �������ν� ��� �׾��ֱ� ���ؼ�
			fos = new FileOutputStream("src/com/lec/ex02_datastream/product.dat", true); 
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.print("�Է��� ��� �� �ֳ���? (y/n)");
				answer = sc.next();
				if (answer.equalsIgnoreCase("n")) {
					break;
				} else if (answer.equalsIgnoreCase("y")) { // ��ǰ��, ����, ����� ���Ϸ� ����ϴ� ����
					System.out.print("��ǰ����? ");
					dos.writeUTF(sc.next());
					System.out.print("������? ");
					dos.writeInt(sc.nextInt());
					System.out.print("��� ������? ");
					dos.writeInt(sc.nextInt());
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
					System.out.println();
					continue;
				}
			} // while
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try{
				if(dos != null) {
					dos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				
			}
		} // finally
		
	} // main


}
