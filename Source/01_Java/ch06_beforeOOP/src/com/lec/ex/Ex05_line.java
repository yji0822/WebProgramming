package com.lec.ex;
/* -------------
���������������������������������������������������
Hello, World!
~~~~~~~~~~~~~~~
Hello, JAVA!
----------------------------------------
Hello, HONG!
�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
 * ��Ȳ�� �´� ���� �����ϴ� ��
 */
public class Ex05_line {
	public static void main(String[] args) {
	
		printLine('��', 50);
		System.out.println("Hello, World!");
		printLine('~');
		System.out.println("Hello, JAVA!");
		printLine(40);
		System.out.println("Hello, HONG!");
		printLine('��', 40);
	
	} // main
	
	private static void printLine (char c, int cnt) {
		for(int i=0; i<cnt; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	private static void printLine(int cnt) {
		for(int i=0; i<cnt; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
	
	private static void printLine(char c) { // �Լ��� �����ε� - �Ű������� �Լ� ����
		for(int i=0; i<15; i++) {
			System.out.print(c);
		}
		System.out.println(); // ���� '-' 20�� ����ϰ� ����
	} 
	
//	private static void printLine() { // ����Ÿ���� ����, �Ű����� ���� �޼ҵ�(�Լ�) void
//		for(int i=0; i<15; i++) {
//			System.out.print('-');
//		}
//		System.out.println(); // ���� '-' 20�� ����ϰ� ����
		
		
//	}

}


