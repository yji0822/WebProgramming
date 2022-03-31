package strategy1.step5.modularization; // ���ȭ ��ǥ - 4�ܰ�
// 4�ܰ� : ����� ��ǰȭ
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
			robot.Shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		
		
	} // main

}
