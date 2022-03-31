package com.lec.ex11_robot;
// RobotOrder order = new RobotOrder();
// order.action(drawRobot�� ��ü); - �κ��� draw�� �� �ֵ���
public class RobotOrder {
	
	public void action(Robot robot) {
	
		// ���ü� ���� ���� ���ü� �ְ� �����ֱ� ���Ͽ�
		if(robot instanceof SingRobot) {
			((SingRobot) robot).sing(); // ����ȯ
		} else if (robot instanceof DanceRobot) {
			((DanceRobot) robot).dance(); // ����ȯ
		} else if (robot instanceof DrawRobot) {
			((DrawRobot) robot).Draw(); // ����ȯ
		} else { // �Ǵٸ� Ȯ�� �κ�������
			System.out.println("Ȯ��� �κ��� �ִٸ� �̰��� �����ϼ���.");
		}
		
	}
	
	
}
