package com.lec.ex11_robot;
// RobotOrder order = new RobotOrder();
// order.action(drawRobot형 객체); - 로봇이 draw할 수 있도록
public class RobotOrder {
	
	public void action(Robot robot) {
	
		// 관련성 없는 것을 관련성 있게 묶어주기 위하여
		if(robot instanceof SingRobot) {
			((SingRobot) robot).sing(); // 형변환
		} else if (robot instanceof DanceRobot) {
			((DanceRobot) robot).dance(); // 형변환
		} else if (robot instanceof DrawRobot) {
			((DrawRobot) robot).Draw(); // 형변환
		} else { // 또다른 확장 로봇ㅋㅋㅋ
			System.out.println("확장된 로봇이 있다면 이곳에 구현하세요.");
		}
		
	}
	
	
}
