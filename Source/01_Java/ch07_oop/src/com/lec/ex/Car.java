package com.lec.ex;
// class: ������(�Ӽ�, �ν��Ͻ�����)�� �޼ҵ�(���, setter, getter)�� �̷���� �ִ�.
// ������ �ϳ��� setter �Ѱ�, getter �Ѱ�
// 6�忡�� �޼ҵ带 �̿��ϴ� �� ��� ��.
// Main()��  Car c = new car()
// c.park()
public class Car {
	private String color; // ����
	private int    cc; // ��ⷮ
	private int    speed; // �ӵ�
	// ������ ������ private�� ����ְ� �����͸� ���� �����ϰ� �ϴ� �Լ�(method)�� ������ش�.
	
	public void drive() {
		speed = 60;
		System.out.println(color + "�� ���� �����Ѵ�. ����"
				+ "�ӵ� : " + speed);
	} // drive 
	public void park() {
		speed = 0;
		System.out.println(color + "�� ���� �����Ѵ�. ����ӵ�: " + speed);
	}
	public void race() {
		speed = 120;
		System.out.println(color + "�� ���� �����Ѵ�. ����ӵ�: " + speed);	
	}
	
	// setter & getter (color, cc, speed) 
	// 1. setter
	// - ���� �Ϲ� �Լ� �ؿ� �ۼ��� ���ش�.
	// - ������ ��Ű�� ������ �ٸ� ���α׷����� ������ �ȵ� ���� �ִ�.
	// myPorsche.methodNName("red"); �̷� ������ ������ ��
	public void setColor(String color) {
		this.color = color; // ���� �� ��ü(�� ��ü)�� color�� private String color�� �����Ѵ�.
	} // return ���� �����Ƿ� void. ���� �޾ƿ��� ����� �����Ƿ�.
	// main�� �ۼ��� ���༭ �ʿ� ����...! set get�� �ʿ�� ����ϸ� �ȴ�.
	public void setCc(int cc) { // myPorsche.setCc(1500); - main���� ����� ����
		this.cc = cc;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	// 2.getter
	public String getColor() {
		return color; // �� ��ü�� color�� �޾ƿ��� ��
	}
	public int getCc() {
		return cc;
	}
	public int getSpeed() {
		return speed;
	}
	
	
		

}
