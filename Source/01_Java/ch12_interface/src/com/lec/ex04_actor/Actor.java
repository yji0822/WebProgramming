package com.lec.ex04_actor;

public class Actor implements IChef, IFireFighter, IPoliceMan {

	private String name;
	public Actor(String name) {
		this.name = name;
	}
	
	@Override
	public void canCatchCriminal() {
		System.out.println(name + "�� ������ ���� �� �ֽ��ϴ�.");
	}

	@Override
	public void canSearch() {
		System.out.println(name + "�� ã�� �� �ֽ��ϴ�.");
	}

	@Override
	public void outFire() {
		System.out.println(name + "�� ���� �� �� �ֽ��ϴ�.");
	}

	@Override
	public void saveMan() {
		System.out.println(name + "�� ����� ���� �� �ֽ��ϴ�.");
	}

	@Override
	public void makePizza() {
		System.out.println(name + "�� ���ڸ� ���� �� �ֽ��ϴ�.");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name + "�� ���İ�Ƽ�� �丮�� �� �ֽ��ϴ�.");
	}

	// getter&setter
	public String getName() {
		return name;
	}

}
