package com.lec.ex;
// 일반 for문 VS 확장 for문(배열출력)
public class Ex02 {

	public static void main(String[] args) {
		int[] arr = new int[3]; // {0, 0, 0} 초기화된 상태

		// 1. 일반 for문을 이용한 배열 출력
		for(int idx=0; idx<arr.length; idx++) {
			System.out.printf("arr[%d] = %d \n", idx, arr[idx]);
		}
		
		// ☆★ 2. 확장 for문을 이용한 배열 출력 . 무지 많이 쓰인다!!!! - 배열 출력만 하는 경우!!!!
		for(int temp : arr) { // 0번째부터 마지막까지 하나씩 뿌려주면서 값만 뿌려주는 목적으로 많이 쓰인다.
			System.out.println(temp); // temp 외에 다른 것은 사용할 수 없다.
		}

		
		// 1-1. 일반 for문을 이용한 배열 수정
		System.out.println("1-1. 일반 for문을 이용한 배열 수정");
		for(int idx=0; idx<arr.length; idx++) {
			arr[idx] = 5;
		} // 모든 배열에 5를 대입
		for(int temp : arr) { // 0번째부터 마지막까지 하나씩 뿌려주면서 값만 뿌려주는 목적으로 많이 쓰인다.
			System.out.println(temp); // temp 외에 다른 것은 사용할 수 없다.
		}
		
		
		// 2-1. 확장 for문을 이용한 배열 수정 - 안된다. temp값에 값을 넣어버리기 때문에 
		// 출력할때만 사용하는 temp문! - 변경하고 싶을때는 그냥 일반 for문을 이용하도록 하자!!!!
		/* 
		System.out.println("2-1. 확장 for문을 이용한 배열 수정");
		for(int temp : arr) { 
			temp = 9;
		}
		for(int temp : arr) { 
			System.out.println(temp);
		}
		*/



		

	}

}
