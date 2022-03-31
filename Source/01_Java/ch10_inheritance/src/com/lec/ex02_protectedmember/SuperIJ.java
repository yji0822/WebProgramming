package com.lec.ex02_protectedmember;
// 데이터 - 생성자 - 메소드 - 오버라이드 메소드(다시 세팅한다) - setter&getter 순서대로 만들어 주어야 한다.
public class SuperIJ {
	private int i;
	private int j;
	
	// 생성자 - 기본 데이터 초기화!!!
	// 상속받은 클래스에서 Super 클래스(부모단) 생성자 함수를 먼저 호출
	// 어느게 먼저 실행되는지 확인 해보기!
	public SuperIJ() {
		System.out.println("매개변수 없는 거 SuperIJ 생성자 함수");
	}
	
	public SuperIJ(int i, int j) {
		super();
		this.i = i;
		this.j = j;
		System.out.println("매개변수 있는 SuperIJ 생성자 함수로 i, j값 초기화");
	}

	// setter & getter
	protected int getI() { // protected
		return i;
	}
	protected void setI(int i) {
		this.i = i;
	}
	protected int getJ() {
		return j;
	}
	public void setJ(int j) { // public
		this.j = j;
	} 
	
	
	
	
	
}
