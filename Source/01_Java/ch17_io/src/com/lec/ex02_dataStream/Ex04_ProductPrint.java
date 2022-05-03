package com.lec.ex02_dataStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

// 파일에 저장된 재고들을 출력 - 계속 read하고 read 다 했으면 close
public class Ex04_ProductPrint {

	public static void main(String[] args) {
		InputStream     fis = null;
		DataInputStream dis = null;
		ArrayList<Product> products = new ArrayList<Product>(); // 재고들을 출력해주는 arraylist
		try {
			fis = new FileInputStream("src/com/lec/ex02_datastream/product.dat");
			dis = new DataInputStream(fis);
			// writeinput한 순서대로 출력해주는 것
			while(true) { 
				String name  = dis.readUTF(); // 상품명 읽어오는 것
				int    price = dis.readInt();
				int    ps    = dis.readInt();
				products.add(new Product(name, price, ps));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("재고데이터 출력"); // 더이상 읽어올 재고 데이터가 없으면 이쪽으로 온다
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
			// ArrayList products 출력
			if(products.isEmpty()) {
				System.out.println("입력된 재고량이 없습니다.");
			} else {
				for(Product product : products) {
					System.out.println(product);
				}
				System.out.println("이상 물품 " + products.size() + "가지 입력 됨");
			} // if-else
		} // finally
		
		
	} // main

}
