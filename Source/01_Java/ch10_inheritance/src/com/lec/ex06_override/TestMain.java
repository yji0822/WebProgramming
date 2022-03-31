package com.lec.ex06_override;

public class TestMain {
	
	public static void main(String[] args) {
		
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass(1);
		
		if(pObj1.equals(pObj2)) {
			System.out.println("두 객체는 같다");
		} // 객체와 객체를 비교할 경우에는 .equals() 함수를 사용한다.
		else {
			System.out.println("두 객체는 다르다");
		}
		// 실행결과 : 두 객체는 다르다
		
		System.out.println();
		ChildClass cObj = new ChildClass(2); 
		if(cObj.equals(pObj2)) {
			System.out.println("override. 무조건 TRUE 출력");
		}
		// 실행결과: override. 무조건 TRUE 출력
		
		System.out.println();
		pObj1.method1();
		pObj1.method2();
//		pObj1.method3(); - 함수가 없으니 실행 불가
		
		System.out.println();
		cObj.method1(); // ChildClass의 method1
		// 오버라이드 하였으므로 pObj1.method1() 과 다른 결과물 출력
		cObj.method2(); // ParentClass의 method2
		cObj.method3(); // ChildClass의 method3
		
		System.out.println();
		ParentClass cObj1 = new ChildClass(2); // 패턴할때 쓴다!
//		cObj1.method3(); - 에러발생
		cObj1.method1(); // ChildClass의 method1 출력
		cObj1.method2(); // ParentClass의 method2출력
//		if(ParentClass형 cObj1변수를 ChildClass형으로 변환 가능하니?) {
//		((ChildClass)cObj1).method3(); - 객체를 명시적으로 형변환 하는 경우는 거의 없음
//		}
//		항상 사용하기 전에 if문으로 물어본 후에 형변환을 해주어야 한다!!!
//		형변환
		System.out.println();
		if(cObj1 instanceof ChildClass) {
			((ChildClass)cObj1).method3();
			System.out.println("오버라이드 형변환 가능");
		} // if
		else {
			System.out.println("형변환 불가");
		}
		
	} // main
} // class
