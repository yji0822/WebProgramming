package com.lec.ex;
// �Ϲ� for�� VS Ȯ�� for��(�迭���)
public class Ex02 {

	public static void main(String[] args) {
		int[] arr = new int[3]; // {0, 0, 0} �ʱ�ȭ�� ����

		// 1. �Ϲ� for���� �̿��� �迭 ���
		for(int idx=0; idx<arr.length; idx++) {
			System.out.printf("arr[%d] = %d \n", idx, arr[idx]);
		}
		
		// �١� 2. Ȯ�� for���� �̿��� �迭 ��� . ���� ���� ���δ�!!!! - �迭 ��¸� �ϴ� ���!!!!
		for(int temp : arr) { // 0��°���� ���������� �ϳ��� �ѷ��ָ鼭 ���� �ѷ��ִ� �������� ���� ���δ�.
			System.out.println(temp); // temp �ܿ� �ٸ� ���� ����� �� ����.
		}

		
		// 1-1. �Ϲ� for���� �̿��� �迭 ����
		System.out.println("1-1. �Ϲ� for���� �̿��� �迭 ����");
		for(int idx=0; idx<arr.length; idx++) {
			arr[idx] = 5;
		} // ��� �迭�� 5�� ����
		for(int temp : arr) { // 0��°���� ���������� �ϳ��� �ѷ��ָ鼭 ���� �ѷ��ִ� �������� ���� ���δ�.
			System.out.println(temp); // temp �ܿ� �ٸ� ���� ����� �� ����.
		}
		
		
		// 2-1. Ȯ�� for���� �̿��� �迭 ���� - �ȵȴ�. temp���� ���� �־������ ������ 
		// ����Ҷ��� ����ϴ� temp��! - �����ϰ� �������� �׳� �Ϲ� for���� �̿��ϵ��� ����!!!!
		/* 
		System.out.println("2-1. Ȯ�� for���� �̿��� �迭 ����");
		for(int temp : arr) { 
			temp = 9;
		}
		for(int temp : arr) { 
			System.out.println(temp);
		}
		*/



		

	}

}
