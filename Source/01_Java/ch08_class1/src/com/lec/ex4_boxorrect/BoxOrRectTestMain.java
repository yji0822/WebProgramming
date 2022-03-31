package com.lec.ex4_boxorrect;

public class BoxOrRectTestMain {

	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5, 6, 10);
		BoxOrRect rect = new BoxOrRect(10, 5);
		box.vPrint(); // box 부피 출력
		rect.vPrint(); // 직사각형 넓이 출력
		System.out.println("box 부피는 " + box.getVolume());
		System.out.println("rect 넓이는 " + box.getVolume());
		
	}

}
