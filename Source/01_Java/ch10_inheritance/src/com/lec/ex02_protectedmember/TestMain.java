package com.lec.ex02_protectedmember;

public class TestMain {

	public static void main(String[] args) {
		Child child = new Child(1, 2);
		/* 출력
		 * 매개변수 없는 거 SuperIJ 생성자 함수
		 * 매개변수 있는 Child 생성자
		 */
		System.out.println("child의 i: " + child.getI()); 
		// child.getI(): 같은 패키지라 사용 가능한 것.
		System.out.println("child의 j: " + child.getJ());
		child.setI(10);
		child.setJ(30);
		child.sum();
		
		// 부모 클래스에서는 무조건 디폴트 생성자가 있어야 한다!
		// 왜 생성자가 있는건 호출이 안되는지..!
		

	}

}
