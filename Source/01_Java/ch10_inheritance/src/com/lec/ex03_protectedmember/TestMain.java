package com.lec.ex03_protectedmember;

public class TestMain {

	public static void main(String[] args) {
		Child child = new Child(1,2); // 매개변수 있는 생성자 함수 출력
		System.out.println("child의 i: " + child.getI());
		System.out.println("child의 j: " + child.getJ());
		child.setI(10); // 값변경
		child.setJ(30);
		child.sum();
	}

}
