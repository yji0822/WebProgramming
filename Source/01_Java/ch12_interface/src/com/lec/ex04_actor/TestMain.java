package com.lec.ex04_actor;

public class TestMain {

	public static void main(String[] args) {
		Actor park = new Actor("�ں���");
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghetti();
		// Actor Ŭ������ �������̽��� ��� implements�� �߱� ������ ��� ��� ����
		
		System.out.println();
		IChef chefPark = new Actor("�ڿ丮��");
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		// IChefŸ���� chefPark�� IChef ���� �Լ��� ��� �����ϴ�.
		
		System.out.println();
		IFireFighter firePark = new Actor("�ڼҹ��");
//		firePark.makePizza();
		firePark.outFire();
		firePark.saveMan();
		
		System.out.println();
		IPoliceMan policePark = new Actor("�ڰ�����");
		policePark.canCatchCriminal();
		policePark.canSearch();
		
	}

}
