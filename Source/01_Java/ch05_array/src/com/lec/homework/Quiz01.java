package com.lec.homework;

public class Quiz01 {

	public static void main(String[] args) {
		// 오늘의 문제1) 배열에 담긴 값을 더하는 프로그램을 작성
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		
		
		// 자주 쓰이는 방식
		System.out.println();
		sum = 0;
		for(int temp : arr) {
			sum += temp;
		}
		System.out.println("total : " + sum);

	}

}
