package com.lec.ex;
// 76, 45, 34, 89, 100, 50, 90, 92 8���� ���� 
// 1���� �迭�� �ʱ�ȭ �ϰ�, ������������ �����ϴ� ���α׷�
public class Ex08_sortArr {

	public static void main(String[] args) {
		
		int[] arr  = {76, 45, 34, 89, 100, 50, 90, 92};
		int[] sortArr = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			sortArr[i] = arr[i];
		} // arr�� sortArr�� ����
		
		// for������ sort(����)�ϴ� ��
		for(int i=0; i<sortArr.length; i++) { // 0~7����
			for(int j=i+1; j<sortArr.length; j++) { // 1~7����
				// i��°�� j���� ���ؼ� i������ ũ�� ��ġ ��ȯ
				if(sortArr[i] > sortArr[j]) {
					int temp = sortArr[i]; // ������ �� �������ִ� ����
					sortArr[i] = sortArr[j]; // j�� ���� ������ ���� �Ǵ�
					sortArr[j] = temp; // ���� �� ����
				} // if
			} // for-j
		} // for-i
		System.out.print("���� ������: ");
		for(int temp : arr) {
			System.out.print(temp + " ");
		}
		System.out.print("\n�������� ������ : ");
		for(int temp : sortArr) {
			System.out.print(temp + " ");
		}
		
		

	}

}
