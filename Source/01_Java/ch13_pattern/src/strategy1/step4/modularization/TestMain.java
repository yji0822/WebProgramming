package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyHigh;
import strategy1.step4.interfaces.FlyYes;

// 5�ܰ� : ����� ��ǰȭ > ���������� �����ϰ� / �����ϱ� ���� 
public class TestMain {
	
	public static void main(String[] args) {
		/* 
		Robot robot = new SuperRobot();
		robot.actionFly();
//		robot.setFly(new FlyNo()); // ��� �ϳ� �ٲٰ� ������ �����ϴ� �� - 5�ܰ�
		robot.actionMissile();
		robot.actionKnife();
		 */

		SuperRobot 		superR    = new SuperRobot();
		StandardRobot 	standardR = new StandardRobot();
		LowRobot 		lowR      = new LowRobot();
		
		Robot[] robots = {superR, standardR, lowR};
		
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		lowR.setFly(new FlyYes());
		
		System.out.println();
		// SuperRobot ���׷��̵� ��û : �� �� �ֽ��ϴ�. => ���� ������� �մϴ�.
		// ��������ϴ� ��ǰ ����� setFly�� ȣ�� > ��ǰ �ִ� ��: �������̽�
		superR.setFly(new FlyHigh()); // ���׷��̵� �ϼ�
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
	} // main

}
