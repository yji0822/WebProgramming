package com.lec.ex02_dataStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

// ���Ͽ� ����� ������ ��� - ��� read�ϰ� read �� ������ close
public class Ex04_ProductPrint {

	public static void main(String[] args) {
		InputStream     fis = null;
		DataInputStream dis = null;
		ArrayList<Product> products = new ArrayList<Product>(); // ������ ������ִ� arraylist
		try {
			fis = new FileInputStream("src/com/lec/ex02_datastream/product.dat");
			dis = new DataInputStream(fis);
			// writeinput�� ������� ������ִ� ��
			while(true) { 
				String name  = dis.readUTF(); // ��ǰ�� �о���� ��
				int    price = dis.readInt();
				int    ps    = dis.readInt();
				products.add(new Product(name, price, ps));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("������� ���"); // ���̻� �о�� ��� �����Ͱ� ������ �������� �´�
		} finally {
			try {
				if(dis != null) {
					dis.close();
				}
				if(fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				
			} // try-catch
			// ArrayList products ���
			if(products.isEmpty()) {
				System.out.println("�Էµ� ����� �����ϴ�.");
			} else {
				for(Product product : products) {
					System.out.println(product);
				}
				System.out.println("�̻� ��ǰ " + products.size() + "���� �Է� ��");
			} // if-else
		} // finally
		
		
	} // main

}
