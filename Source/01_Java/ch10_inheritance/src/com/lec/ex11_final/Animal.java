package com.lec.ex11_final;

public class Animal {
	
	protected int speed;

	// �޼ҵ�
	public void running() {
		speed += 5;
		System.out.println("�ٰ� �־��. ����ӵ�: " + speed);
	}
	public final void stop() { // override ���� �޼ҵ� - ������ ������ �ӵ��� 0!!
		speed = 0;
		System.out.println("����");
	}

	// getter setter 
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	

}
