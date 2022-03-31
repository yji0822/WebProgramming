package com.lec.ex4_object;

public class Ex02_PersonTestMain {

	public static void main(String[] args) {
		
		Person p1 = new Person(9512121021021L); // long형이기 때문에 L을 꼭 붙여준다.
		Person p2 = new Person(9512121021021L);
		Person p3 = null;
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		if(p1.equals(p2)) {
			System.out.println("p1과 p2는 같은 사람");
		} else {
			System.out.println("p1과 p2는 다른 사람");
		} // 다른 사람 출력 - equals 오버라이드로 같은 사람 출력이 된다!
		
		System.out.println(p1.equals(p3)? "p1이랑 p3는 같은 사람" : "p1이랑 p3랑 "
				+ "다른 사람");
		
		if(p1==p2) { // 주소가 같냐고 물어보는 것
			System.out.println("p1과 p2는 같은 주소");
		} else {
			System.out.println("p1과 p2는 다른 주소");
		} // 다른 주소 출력

	}

}
