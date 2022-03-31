package com.lec.ex;
// 76, 45, 34, 89, 100, 50, 90, 92 8개의 값을 
// 1차원 배열로 초기화 하고, 오름차순으로 정렬하는 프로그램
public class Ex08_sortArr {

	public static void main(String[] args) {
		
		int[] arr  = {76, 45, 34, 89, 100, 50, 90, 92};
		int[] sortArr = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			sortArr[i] = arr[i];
		} // arr을 sortArr로 복사
		
		// for문으로 sort(정렬)하는 법
		for(int i=0; i<sortArr.length; i++) { // 0~7까지
			for(int j=i+1; j<sortArr.length; j++) { // 1~7까지
				// i번째와 j번쨰 비교해서 i번쨰가 크면 위치 교환
				if(sortArr[i] > sortArr[j]) {
					int temp = sortArr[i]; // 이전의 값 저장해주는 변수
					sortArr[i] = sortArr[j]; // j의 값이 앞으로 가게 되는
					sortArr[j] = temp; // 이전 값 저장
				} // if
			} // for-j
		} // for-i
		System.out.print("원래 데이터: ");
		for(int temp : arr) {
			System.out.print(temp + " ");
		}
		System.out.print("\n오름차순 데이터 : ");
		for(int temp : sortArr) {
			System.out.print(temp + " ");
		}
		
		

	}

}
