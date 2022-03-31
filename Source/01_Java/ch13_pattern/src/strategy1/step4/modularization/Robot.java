package strategy1.step4.modularization;

import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;

public abstract class Robot { // ��ü ������ abstract�Լ��� ��� ����� ���� 
	// Robot r = new Robot();
	// r.actionFly(); - �����ڿ��� fly=new FlyNo() �̷��� ���� �ʾұ� ������ ����.
	// �̸� �����ϰ��� ��ü ���� �Ұ� �ϵ��� abstract class�� ����� ���´�.
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�޸� �� �ֽ��ϴ�.");
	}
	public void shape() {
		String className = getClass().getName(); // Ŭ���� �̸� �������� �޼ҵ�
		// stragegy1.step2.superRobot 
		// �� ������ ���� ���� ��ġ
		int idx = className.lastIndexOf('.'); // �Ǹ�����'.'�� ��ġ�� ������ �������ش�
		String name = className.substring(idx+1); // idx+1��° �۾����� ������
		System.out.println(name + "�Դϴ�. ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	} 
	// ����� �޼ҵ� ���� �س���
	public void actionFly() {
		fly.fly();
	}
	public void actionMissile() {
		missile.missile();
	}
	public void actionKnife() {
		knife.knife();
	}
	
	// Setter
	public void setFly(IFly fly) {
		this.fly = fly;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
	
	
}
