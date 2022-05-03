package com.lec.ex02_dataStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_ProductWriter { // 재고입력 프로그램 (사용자가 'n'을 입력하기 전까지 무한 반복) -  상품명, 가격, 재고량을 입력 받아 파일 출력
//	재고는 데이터 파일로 입력 받아서 출력할 예정 

	public static void main(String[] args) {
		// while의 단점 - 한번 입력하면 수정하기가 힘들다.다 불러들인 다음에 제품을 부른 다음 수정 해주어야 한다.
		Scanner sc = new Scanner (System.in);
		String answer; // y or n 입력받는 변수
		OutputStream fos     = null; // 재고 입력받는 변수
		DataOutputStream dos = null;
		try {
			// 같은 패키지 밑에 넣고 싶을때(특정한 경로지정)/ true를 써줌으로써 재고를 쌓아주기 위해서
			fos = new FileOutputStream("src/com/lec/ex02_datastream/product.dat", true); 
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.print("입력할 재고가 더 있나요? (y/n)");
				answer = sc.next();
				if (answer.equalsIgnoreCase("n")) {
					break;
				} else if (answer.equalsIgnoreCase("y")) { // 상품명, 가격, 재고량을 파일로 출력하는 로직
					System.out.print("상품명은? ");
					dos.writeUTF(sc.next());
					System.out.print("가격은? ");
					dos.writeInt(sc.nextInt());
					System.out.print("재고 수량은? ");
					dos.writeInt(sc.nextInt());
				} else {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
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
