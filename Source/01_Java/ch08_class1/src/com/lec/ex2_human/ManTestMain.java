package com.lec.ex2_human;

public class ManTestMain {

	public static void main(String[] args) {
		
		Man kim = new Man();
		kim.setAge(28);
		kim.setHeight(168);
		kim.setWeight(55.0);
		kim.setPhoneNum("010-5555-6666");
		System.out.println("kim = " + kim.getAge() + "��, " + kim.getHeight()
				+ "cm, " + kim.getWeight() + "kg, " + kim.getPhoneNum());
		
		Man kang = new Man(22, 165, 60.5); // �ڵ��� ��ȣ�� ���� ������ ȣ��
		kang.setPhoneNum("010-123-4567");
		System.out.println("kang = " + kang.getAge() + "��, " + kang.getHeight()
				+ "cm, " + kang.getWeight() + "kg, " + kang.getPhoneNum());
		
		Man moon = new Man(20, 180, 70, "010-9999-9999");
		System.out.println("moon = " + moon.getAge() + "��, " + moon.getHeight()
		+ "cm, " + moon.getWeight() + "kg, " + moon.getPhoneNum());
		
		Man yi = new Man(22);
	
		
//		Man yu = new Man(165); - Ű�� �ް� ������ �̹� ���̸� �����ڷ� �����Ǿ Ű�� �ƴ� ���̷� �ν��� �ȴ�.
		// �����ڰ� �ʿ��� ���� : �ڵ��� ���̰�..
		// Ŭ������ ������ ���Ϸ�..!
		
		// �� ��Ű���� �������� Ŭ����! Man & Woman Ŭ����
		

	}

}
