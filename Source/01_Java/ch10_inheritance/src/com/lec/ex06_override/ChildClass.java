package com.lec.ex06_override;
// ParentClass의 method1(), method2() 상속 받음
public class ChildClass extends ParentClass {
	
	public ChildClass() {
		System.out.println("매개변수 없는 ChildClass 생성자");
	}
	public ChildClass(int i) {
		System.out.println("매개변수 있는 ChildClass 생성자");
	}
	
	// method
	public void method3() {
		System.out.println("ChildClass의 method3() 함수");
	}
	
	// override
	@Override
	public void method1() { // ParentClass의 method1 오버라이드
		System.out.println("ChildClass의 method1() 함수");
	} // 접근제한자의 범위만 좀 바뀔 수 있다. but private > public 식으로
	// ChildClass만을 위한 method1()
	@Override
	public boolean equals(Object obj) { // Object클래스의 equals함수 override
		return true;
	} // 무조건 true를 출력하는 것으로 변경
	
	
	
}
