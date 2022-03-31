package com.lec.ex2_human.main; // human이란 폴더 밑에 main

import com.lec.ex2_human.*; 
// 'import com.lec.ex2_human 패키지의 모든 클래스(class)를 가져온다.(import)
// import com.lec.ex2_human.Woman;
// import com.lec.ex2_human.Man;
// ctrl + shift + o = 필요한 패키지만 불러들이는 단축키

public class TestMain {

	public static void main(String[] args) {
		
		// 기초 데이터 타입에서의 같은지 비교는 "==" 사용
		int i = 10;
		int j = 10;
//		System.out.println( i==j ? "삼항연산자 i와 j는 같다" : "다르다");
		if(i==j) {
			System.out.println("i와 j는 같다");
		}
		else {
			System.out.println("다르다");
		} 
		
		// ※ 예외사항 : 객체변수 String - 예외로 "==" 사용할 수 있도록 허용
		String name = "홍길동"; 
		String name2 = "홍길동";
		if(name == name2) {
			if(name.equals(name2)) {
				System.out.println("name과 name2는 같다");
			}
		} // 같은 값이 들어갔으면 같은 주소를 가리키기 때문에 같다고 말한다. api에서 더 자세히 배울 예정
		
		Woman hee1 = new Woman(); // 에러발생 - 클래스 import해야함
		Woman hee2 = new Woman();
//		hee1.method();
		// hee1이라는 주소객체와 hee2라는 객체가 따로 생성된 것이다!
		if(hee1.equals(hee2)) {
			System.out.println("hee1과 hee2는 같다");
		}
		else {
			System.out.println("hee1과 hee2는 다르다!!");
		} // 에러 안나고 실행은 되나, 다르다 출력. 다형성
		// 내가 만들지 않아도 equals() 같이 특정한 클래스를 상속 받아서 리모델링 해서 사용 가능.
		// equals()는 java.lang.object한테 상속받아서 사용하는 것
		// 왜 실행되는지 이해를 해야한다.
		
		Man kang = new Man(22, 165, 60.1);
		Man kim = new Man(23, 175, 70.5);
		Man kim1; // 레퍼런스 변수 선언(= 객체변수 선언) 메모리에 주소 담을 준비만 하는 중.
		kim1 = kim; // kim의 주소가 9면 kim1의 주소도 9이다.
		Man kim2 = new Man(23, 175, 70.5); // 다른 주소값에 저장되어 있으므로 kim과 다른 객체임!
		if(kim.equals(kim1)) {
			System.out.println("kim과 kim1은 같다.(같은 주소를 가리킨다)");
		}
		if(kim.equals(kim2)) {
			System.out.println("kim과 kim2는 같다(주소값이 같다.)");
		}
		if(!kim.equals(kim2)) {
			System.out.println("kim과 kim2는 다른 주소값을 가지고 있다.");
		}
		
		kang.setHeight(160); // 값 변경
		kang.setWeight(51); // 값 변경 - 정수형으로 적어줘도 double형이기 때문에 묵시적 형변환 가능 
		System.out.println("kang님,  키: " + kang.getHeight() + ", 몸무게: " + kang.getWeight());
		if(kang.calculateBMI() > 30) {
			System.out.println("건강유의하세요");
		} else {
			System.out.println("건강하시군요!");
		}
		
		
	
	}

}
