package com.lec.loop;
// �ǽ����� �� for���� while���� �̿��ؼ� 1~100���� ���� �� 3�� ��� ��(�Ǵ� ������)�� ���غ���
public class Ex07_for_while {

	public static void main(String[] args) {
		
		// for
		int sum = 0;
		
		for(int i=1; i<=100; i++) {
			if(i % 3 == 0) { 
				sum += i;
			} // if
		} // for
		System.out.println("for��: �������� " + sum);
		
		
		// while
		sum = 0;
		int i = 0;
		while (i<=100) {
			if (i%3 == 0) {
				sum += i;
			}
			++i;
		}
		System.out.println("while��: " +sum);

		
	}

}
