package com.lec.loop;
// ���� �� ������ ���� ��� ������ �������� ����ϴ� ���α׷��� ������ ����
public class Quiz4 {
	public static void main(String[] args) {
		
		for (int i=1; i<=9; i++) { // ��
			for (int j=2; j<=9; j++) { // ��
				System.out.print(j + " X " + i + " = " + (i*j) + "\t");
				// System.out.printf("%d * %d = %d \t", j, i, j*i);
			} // for j
			System.out.println(); // ����
		} // for i
		
		
	}
}

