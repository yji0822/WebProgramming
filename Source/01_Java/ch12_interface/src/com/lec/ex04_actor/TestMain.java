package com.lec.ex04_actor;

public class TestMain {

	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghetti();
		// Actor 클래스는 인터페이스를 모두 implements를 했기 때문에 모두 사용 가능
		
		System.out.println();
		IChef chefPark = new Actor("박요리사");
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		// IChef타입의 chefPark는 IChef 안의 함수만 사용 가능하다.
		
		System.out.println();
		IFireFighter firePark = new Actor("박소방관");
//		firePark.makePizza();
		firePark.outFire();
		firePark.saveMan();
		
		System.out.println();
		IPoliceMan policePark = new Actor("박경찰관");
		policePark.canCatchCriminal();
		policePark.canSearch();
		
	}

}
