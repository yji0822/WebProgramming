package com.lec.homework;

public class Quiz03 {

	public static void main(String[] args) {
		// 오늘의 문제3) 76, 45, 34, 89, 100, 50, 90, 92 
		// 8개의 값을 1차원 배열로 초기화 하고 값의 합계와 평균 그리고 최대값과 최소값을 구하시오.
		
		int[] arr = {76, 45, 34, 89, 100, 50, 90, 92};
		int sum = 0, avg; // 합, 평균
		
		// 배열 출력
		System.out.print("int[] arr  =    ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		// 총합
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("총합: " + sum);
		
		// 평균
		avg = sum / arr.length;
		System.out.println("평균: " + avg);
		
		// 최대, 최소
		int max = 0;
		int min = 999;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			} // if - max
			if(arr[i] < min) {
				min = arr[i];
			} // if - min
		} // for
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);

	}

}
