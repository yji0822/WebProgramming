package com.lec.ex03_protectedmember;

public class SuperIJ {
	// 데이터
	private int i;
	private int j;
	
	// 생성자
	public SuperIJ() {
		System.out.println("매개변수 없는 SuperIJ 생성자");
	}
	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("매개변수 있는 SuperIJ 생성자 함수. i&j값 초기화");
	}
	
	// getter&setter
	protected int getI() {
		return i;
	}
	protected void setI(int i) {
		this.i = i;
	}
	protected int getJ() {
		return j;
	}
	protected void setJ(int j) {
		this.j = j;
	}
	
}
