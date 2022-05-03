package com.lec.ex1_tryCatch;

public class Ex04_finally {

	public static void main(String[] args) {
		
		int[] arr = {0,1,2};
		
		for(int i=0; i<=arr.length; i++) {
			try {
				System.out.println("arr[" + i +"] = " + arr[i]);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("예외 메세지 : " + e.getMessage());
			} finally { // 예외사항에도 넣어주고 싶고, 예외가 아니고 싶어도 넣어주고 싶을 때 쓰는  finally
				System.out.println("try절 실행 후에도 catch절 실행 후에도 여기는 결국 반드시 실행되는 부분");
			} // try-catch-finally
		} // for
		System.out.println("프로그램 끝!");

	}

}
