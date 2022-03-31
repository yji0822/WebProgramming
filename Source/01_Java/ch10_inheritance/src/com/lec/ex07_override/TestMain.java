package com.lec.ex07_override;

public class TestMain {

	public static void main(String[] args) {
		
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass();
		
		if(pObj1.equals(pObj2)) { // 객체와 객체를 비교할 경우에는 .equals()함수를 사용한다.
			System.out.println("두 객체는 같다.");
		} else {
			System.out.println("두 객체는 다르다.");
		}
		// 실행결과 : 두 객체는 다르다.
		
		System.out.println();
		ChildClass cObj = new ChildClass(2);
		if(cObj.equals(pObj2)) {
			System.out.println("오버라이드. 무조건 TRUE 출력");
		}
		
		System.out.println();
		pObj1.method1();
		pObj1.method2();
//		pObj1.method3(); - ParentClass에는 메소드가 없으므로 실행 불가
		
		System.out.println();
		cObj.method1(); // ChildClass의 method1 - 오버라이드 함수
		cObj.method2(); // ParentClass의 method2
		cObj.method3(); // ChildClass의 method3
		
		System.out.println();
		ParentClass cObj1 = new ChildClass(2);
//		cObj1.method3(); - ParentClass에는 없는 메소드
		cObj1.method1(); // ChildClass의 method1 출력 - 오버라이드 함수
		cObj1.method2(); // ParentClass의 method2 출력
		// 형변환 - 인위적으로 바꾼 것이므로 if문을 사용하여 변경해준다.
		if(cObj1 instanceof ChildClass) {
			((ChildClass)cObj1).method3();
			System.out.println("오버라이드 형변환 가능");
		} else {
			System.out.println("형변환 불가");
		}
		
		
		
		


	}

}
