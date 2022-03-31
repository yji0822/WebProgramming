package com.lec.ex2_human;

public class ManTestMain {

	public static void main(String[] args) {
		
		Man kim = new Man();
		kim.setAge(28);
		kim.setHeight(168);
		kim.setWeight(55.0);
		kim.setPhoneNum("010-5555-6666");
		System.out.println("kim = " + kim.getAge() + "세, " + kim.getHeight()
				+ "cm, " + kim.getWeight() + "kg, " + kim.getPhoneNum());
		
		Man kang = new Man(22, 165, 60.5); // 핸드폰 번호만 없는 생성자 호출
		kang.setPhoneNum("010-123-4567");
		System.out.println("kang = " + kang.getAge() + "세, " + kang.getHeight()
				+ "cm, " + kang.getWeight() + "kg, " + kang.getPhoneNum());
		
		Man moon = new Man(20, 180, 70, "010-9999-9999");
		System.out.println("moon = " + moon.getAge() + "세, " + moon.getHeight()
		+ "cm, " + moon.getWeight() + "kg, " + moon.getPhoneNum());
		
		Man yi = new Man(22);
	
		
//		Man yu = new Man(165); - 키를 받고 싶지만 이미 나이를 생성자로 설정되어서 키가 아닌 나이로 인식이 된다.
		// 생성자가 필요한 이유 : 코딩을 줄이고..
		// 클래스는 서른자 이하로..!
		
		// 한 패키지에 여러가지 클래스! Man & Woman 클래스
		

	}

}
