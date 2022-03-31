package strategy1.step5.modularization; // 모듈화 목표 - 4단계
// 4단계 : 기능을 부품화
public class TestMain {
	
	public static void main(String[] args) {
		/* 
		Robot robot = new SuperRobot();
		robot.actionFly();
//		robot.setFly(new FlyNo()); // 기능 하나 바꾸고 싶을때 변경하는 법 - 5단계
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
