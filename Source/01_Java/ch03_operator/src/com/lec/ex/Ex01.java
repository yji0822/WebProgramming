package com.lec.ex;
// ��������� : +	-	*	/	%(������)
public class Ex01 {

	public static void main(String[] args) {
		int n1 = 33, n2 = 10;
		int result; // + - * % �� ��� 
		double resultDouble; // / �� ���
		
		result = n1 + n2;
		System.out.printf("%d %c %d = %d \n", n1, '+', n2, result ); // 33+10=43
		
		result = n1 - n2;
		System.out.printf("%d %c %d = %d \n", n1, '-', n2, result );
		
		result = n1 * n2;
		System.out.printf("%d %c %d = %d \n", n1, '*', n2, result ); 
		
		result = n1 % n2;
		System.out.printf("%d %c %d = %d \n", n1, '%', n2, result ); 
		
		resultDouble = (double)n1 / n2; // **����� ����ȯ
		System.out.printf("(printf) %d %c %d = %f \n", n1, '/', n2, resultDouble ); 
		System.out.println("(println) " + n1 + " / " +n2 + " = " + resultDouble);
		
		// ¦�� Ȧ�� ���й�
		if(n1%2 == 0) {
			System.out.println("n1�� ¦��");
			System.out.println("n1�� ¦��! �׸��� ������ �ݿ��Ϥ�");
		}
		else {
			System.out.println("n1�� Ȧ��");
			System.out.println("n1�� Ȧ���� ������ ���� �ݿ���!!!");
		}
		
		// ������й�
		if(n1%5 == 0) {
			System.out.println("n1�� 5�� ���");
		}
		else {
			System.out.println("n1�� 5�� ����� �ƴ�");
		}
	
		
	}
}

