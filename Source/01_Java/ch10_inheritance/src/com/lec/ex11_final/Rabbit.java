package com.lec.ex11_final;
// Animal�κ��� speed, running(), stop() ��ӹ���
public final class Rabbit extends Animal { // �ٸ� ���� ����� ���� ���� ������ ����� �޾ƿ� ���� �ִ�.

	@Override
	public void running() {
		setSpeed(getSpeed() + 30); // speed += 30;
		System.out.println("���� �پ��. ����ӵ�: " + getSpeed());
	}
	
	/*
	 * ����
	public void stop() {
		
	}
	*/
	
}
