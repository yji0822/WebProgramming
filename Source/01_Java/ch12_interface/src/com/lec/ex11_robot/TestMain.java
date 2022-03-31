package com.lec.ex11_robot;

public class TestMain {

	public static void main(String[] args) {
		
		Robot[] robots = { new SingRobot(), new DanceRobot(), new DrawRobot() };
		RobotOrder order = new RobotOrder();
		for(Robot robot : robots)
		order.action(robot);
	} // 추가하고 싶은 것들이 있으면 RobotOrder에서 추가하면 된다!

}
