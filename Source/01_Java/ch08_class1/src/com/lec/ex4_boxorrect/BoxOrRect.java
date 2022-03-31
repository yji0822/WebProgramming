package com.lec.ex4_boxorrect;
/* (실습예제2) 직육면체의 가로, 세로, 높이, 부피나 직사각형의 가로, 세로, 넓이를 속성으로 갖는 클래스를 구현하라. 부피나 넓이를 리턴하는 메소드 getVolume(), 출력하는 메소드 vPrint()도 구현한다.
가로, 세로만 있으면 직사각형으로 인식
데이터: 가로, 세로, 높이, area(부피 or 넓이)
메소드 : int getVolume(), void vPrint() */
public class BoxOrRect {
	private int width;
	private int height;
	private int depth; // box일 경우 깊이, rect일 경우 0 출력
	private int volume; // box일 경우 부피, rect일 경우 넓이
	
	// 생성자
	public BoxOrRect() {}
	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		volume = width * height;
	} // rect생성자
	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width*height*depth;
	} // box생성자
	
	// method
	public int getVolume() {
		return volume;
	}
	public void vPrint(){
		if(depth!=0) { // box
		System.out.println("부피는 " + volume + "cm3");
		} else { // rect
			System.out.println("넓이는 " + volume + "cm2");
		}
	} // 화면에 출력해주는 함수
	
	
	

	
}
