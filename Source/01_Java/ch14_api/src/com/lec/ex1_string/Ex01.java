package com.lec.ex1_string;

public class Ex01 {
	
	public static void main(String[] args) {
		
		String str1 = "Java";
		String str2 = "Java";
		// String new�� �������� �ʰ� ""��  ����� ���ڿ�  ����� �̿�, �ڵ����� �� (JVM���� �ڵ����� �޸� ����)
		// �ڵ����� �� ������ String ��ü�� �̹� �����ϴ��� Ȯ���ϰ�
		// �����ϸ� �̹� �����ϴ� ���ڿ� ��ü�� �����Ѵ�. �������� �ʴ´ٸ� String ��ü�� �����Ѵ�. (new�� ������ ���ο� ��ü ����)
		// String ���� ���ܸ� �� ����.
		String str3 = new String("Java"); // ������ ��ü ����
		
		if (str1 == str2) {
			System.out.println("str1�� str2�� ���� �ּҰ��� ����");
		} else {
			System.out.println("str1�� str2�� �ٸ� �ּҰ��� ����");
		}
		
		if(str1.equals(str2)) {
			System.out.println("str1�� str2�� ���� ���ڿ�");
		}
		
		System.out.println(str1==str3 ? "str1�� 3�� ���� �ּ�" : "str1�� str3�� �ٸ� �ּ�");
		System.out.println(str1.equals(str3)? "���� String" : "�ٸ� ���ڿ�");
			
			
	} // main
	
}
