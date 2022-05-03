package com.lec.ex1_tryCatch;
import java.util.InputMismatchException;
// ���� ó�� �߰�
// �߻��� �� �ִ� ���ܵ� : ArithmeticException, InputMismatchException(int����string�Է�������)
import java.util.Scanner;

public class Ex03 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int i, j=1;
		
		do{
			try {
				System.out.print("��Ģ������ �� ù��° �� : ");
				i = sc.nextInt(); // i�� ������ �ùٸ��� �������� break�� ������������ �ϴ�..!
				break;
			} catch(Exception e) {// InputMismatchException e
				System.out.println("(���� �޼���) " + e.getMessage());
				System.out.println("������ �ݵ�� �Է��ϼ���."); 
				sc.nextLine(); // next()�� �����־ �ȴ�. - ���۸� ����� �������� �ۼ�
			}
		}while(true);
		
		System.out.print("��Ģ������ �� �ι�° �� : "); // 0 �� �Է��ϸ� ���ܹ߻�
		// ���ܰ� �߻��� �� �ִ� �κе��� try-catch�� ���α�
		try { // �ߺ� try���� ������� �ʴ´�.
			j = sc.nextInt();
			System.out.println("i = " + i + ", j = " + j);
			System.out.println("i X j = " + (i*j));
			System.out.println("i / j = " + (i/j));
		} catch(InputMismatchException e) {
			System.out.println("(���ܸ޼���) " + e.getMessage());
			System.out.println("�ι�° ���� �߸� �Է��Ͻø� 1�� �ʱ�ȭ ��");
		} catch(ArithmeticException e) { // try���� ������ ���ܰ� �߻��� ��쿡�� catch���� �� �ۼ����ش�.
			System.out.println(e.getMessage());
		} catch (Exception e) { // ����Ŭ������ �ƹ� ��ü�� ����ó���� �����ϴ�.
			System.out.println("(���ܸ޼���-Exception)" + e.getMessage()); 
		}
		
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("Done");
		
		
		sc.close();
		
	}
}
