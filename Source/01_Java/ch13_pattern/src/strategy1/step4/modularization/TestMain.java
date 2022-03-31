package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyHigh;
import strategy1.step4.interfaces.FlyYes;

// 5단계 : 기능을 부품화 > 유지보수를 간편하게 / 협업하기 쉽고 
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
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		lowR.setFly(new FlyYes());
		
		System.out.println();
		// SuperRobot 업그레이드 요청 : 날 수 있습니다. => 높이 고공비행 합니다.
		// 고공비행하는 부품 만들어 setFly만 호출 > 부품 있는 곳: 인터페이스
		superR.setFly(new FlyHigh()); // 업그레이드 완성
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
