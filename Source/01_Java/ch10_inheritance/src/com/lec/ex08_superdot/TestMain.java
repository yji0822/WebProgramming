package com.lec.ex08_superdot;
// ParentClass - i (private), method(), getI()
// ChildClass - i(private), method(), getI();
public class TestMain {

	public static void main(String[] args) {
		
		ChildClass child = new ChildClass();
//		ParentClass default 생성자
//		ChildClass 디폴트 생성자
		// 메인함수에서는 super 못쓴다! main 함수에서의 superclass를 찾을 것임
		System.out.println(child.getI()); // 99
		child.method();
//		ChildClass의 method
//		ParentClass의 method, super 단의 i는 20
//		ChildClass에서 super의 i = 20, Child 단의 i = 99
		

	}

}
