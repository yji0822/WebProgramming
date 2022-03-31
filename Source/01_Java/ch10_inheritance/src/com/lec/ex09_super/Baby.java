package com.lec.ex09_super;
// name, character / intro() - 모두 포함된 상태
// Baby b = new Baby("홍아가", "이뻐"); - 초기화
// Baby b1 = new Baby(); - 초기화X
public class Baby extends Person {

	// 생성자
	public Baby() {
		System.out.println("매개변수 없는 Baby 생성자");
	}
	public Baby(String name, String character) {
		super(name, character); // 반드시 맨 첫줄에 써주어야 한다!! this(), super(); - 생성자 호출
//		setName(name);
//		setCharacter(character); // 기존에 쓰던 방식
		System.out.println("매개변수 있는 Baby 생성자");
	}
	
	// method
	@Override
	public void intro() {
		System.out.println("응애응애 난 아가야"); // 출력하고
		super.intro(); // 내 클래스의 super단에 있는 intro() 실행하란 뜻
	}
	
	
	
}
