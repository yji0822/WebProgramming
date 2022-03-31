package com.lec.ex01;

public class TestMain {

	public static void main(String[] args) {
//		InterfaceEx1 ex1 = new InterfaceEx1(); // 인터페이스 객체 생성 불가
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		System.out.println(obj1.CONSTANT_NUM + " / " + obj1.COSNTANT_STRING); // 객체변수로 static access 비추
		System.out.println(InterfaceEx1.CONSTANT_NUM + " / " + InterfaceEx2.COSNTANT_STRING);
		
		
		InterfaceEx1 obj2 = new InterfaceClass();
		obj2.method1();
//		obj2.method2(); 불가. 형변환 해야함 InterfaceEx1 타입이기 때문에
		if(obj2 instanceof InterfaceClass) {
			((InterfaceClass) obj2).method2(); // 형변환
		} // 상황에 따라 inteface1만 실행하고플때랑. 2만 실행하고플때 사용 많이 한다.
//		System.out.println(obj2.CONSTANT_STRING); 오류
		
		
		InterfaceEx2 obj3 = new InterfaceClass();
//		obj3.method1(); 불가
		obj3.method2(); // 가능
		
		
		
	}

}
