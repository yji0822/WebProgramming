package com.lec.loop;
// �ǽ����� �� for���� �̿��ؼ� 1~40���� ���ٿ� 4���� ����Ͻÿ�
// ��ǰ ������ �� ���� ���δ�.
// 1 2 3 4
// 5 6 7 8
// 9 10 11 12...
public class Ex04_for {

	public static void main(String[] args) {
		for(int i=1; i<=40; i++) {
			System.out.print(i + "\t");
			if (i%4 == 0) {
				System.out.println(); // i�� 4�� ����� ���� �߰�
			} // if
		} // for

	}

}
