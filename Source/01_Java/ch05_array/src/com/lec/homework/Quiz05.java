package com.lec.homework;

import java.util.Arrays;

public class Quiz05 {
	public static void main(String[] args) {
		
		int[] arr = {76, 45, 34, 89, 100, 50, 90, 92};
		// 복사를 해주어야 한다.
		int[] sortArr = new int[arr.length];
		
		for (int i=0; i<arr.length; i++) {
			sortArr[i] = arr[i];
		} // arr을 복사
		
		// for문으로 sort(정렬) 하는 법
		// 1. 오름차순
		// Arrays.sort(sortArr);
		for (int i=0; i<sortArr.length; i++) { // i = 0~7까지
			for(int j=i+1; j<sortArr.length; j++) { // j = i+1~7까지
				// i번째와 j번째 비교해서 i번째가 크면 위치 교환
				if(sortArr[i] > sortArr[j]) {
					// 주의사항: 값을 대입해버리면 전의 값이 사라지기 때문에 
					// 그 값을 저장할 변수를 하나 만들어주어야 한다.
					int temp = sortArr[i];
					sortArr[i] = sortArr[j]; // j가 앞으로 가게 되는
					sortArr[j] = temp;
				} // if
			} // for - j
		} // for - i
		System.out.print("원래 데이터 : ");
		for(int temp : arr) {
			System.out.print(temp + " ");
		}
		System.out.print("\n오름차순 데이터 : ");
		for(int temp : sortArr) {
			System.out.print(temp + " ");
		}
		

//		Arrays.sort(arr);
//		for(int temp : arr) {
//			System.out.printf("%d \t" ,temp);
//		}
		
			
	}

}
