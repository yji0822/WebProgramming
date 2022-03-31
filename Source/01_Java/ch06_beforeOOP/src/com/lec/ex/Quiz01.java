package com.lec.ex;
import java.util.Scanner;

// ����ڷκ��� ���ϴ� �ܼ�(2~9) �������� ����ϴ� ���α׷��� �����Ͻÿ�.
// (��, �ܼ��� �Ű������� �޾� �ش� �ܼ��� �������� ����ϴ� �κ��� method�� ó���Ѵ�. 
// ����ڰ� 2~9 ������ ���� �ƴ� ���� �Է��� �� 2~9������ ���� �Է��� ������ ��� �Է� �޴´�.)
// hint : method(int dansu) / do~while���̳� while�� �̿�

// �پ��� �������  �������� git�� �ø��Ű� �����ϱ�. 
public class Quiz01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int dansu;
		do {
			System.out.print("����ϰ� ���� ���� �Է��ϼ���: ");
			dansu = sc.nextInt();		
		}
		while(dansu<2 || dansu>9);
		method(dansu);
	
		sc.close();
	} // main
	
	private static void method(int dansu) {
			for (int i=1; i<=9; i++) {
				System.out.println(dansu + " X " + i + " = " + (dansu*i));
		} // for	
	} // method

}
