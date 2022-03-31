package com.lec.ex4_car;
// LowGradeCar : tax, color(���), tire(�Ϲ�Ÿ�̾�), displacement(2000), handle(�Ŀ��ڵ�), getSpec()
// Car c = new LowGradeCar("����", "����", 1490, "�Ŀ�");
public class LowGradeCar extends Car {
	private int tax; // �ڵ�����
	
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 50000; // �����ڿ��� ������ �ʱ�ȭ
	} 

	// �߻�Ŭ������ �ͼ� ������ ����� �Ѵ�!
	@Override
	public void getSpec() { // spec�� (����, Ÿ�̾�, ��ⷮ, �ڵ�, ����) �� ���
		// ���� �ݾ� ����
		if(getDisplacement() > 1000) {
			tax += (getDisplacement()-1000)*100;
		} // 5������ �ʱ�ȭ �ؼ� ��� X
		System.out.println("����    : " + getColor());
		System.out.println("Ÿ�̾� : " + getTire());
		System.out.println("��ⷮ : " + getDisplacement() + "cc");
		System.out.println("�ڵ�    : " + getHandle());
		System.out.println("����    : " + tax + "��");
		System.out.println("----------------");
	}

}
