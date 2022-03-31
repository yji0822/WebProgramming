package strategy1.step5.modularization;

public abstract class Robot {
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�޸� �� �ֽ��ϴ�.");
	}
	public void Shape() {
		String className = getClass().getName(); // Ŭ���� �̸� �������� �޼ҵ�
		// stragegy1.step2.superRobot 
		// �� ������ ���� ���� ��ġ
		int idx = className.lastIndexOf('.'); // �Ǹ�����'.'�� ��ġ�� ������ �������ش�
		String name = className.substring(idx+1); // idx+1��° �۾����� ������
		System.out.println(name + "�Դϴ�. ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	} 
	// ����� �޼ҵ� ���� �س���
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
}
