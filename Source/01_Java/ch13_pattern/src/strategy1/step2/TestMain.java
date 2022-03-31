package strategy1.step2;

public class TestMain {

	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		for(Robot robot : robots) {
			System.out.println();
			robot.Shape();
			robot.actionRun();
			robot.actionWalk();
		
			// 변수가 Robot형이라 actionFly() 안된다. -형변환
			if(robot instanceof SuperRobot) {
				SuperRobot r = (SuperRobot)robot;
				r.actionFly();
				r.actionMissile();
				r.actionKnife();
			} else if(robot instanceof StandardRobot) {
				StandardRobot r = (StandardRobot) robot;
				r.actionFly();
				r.actionMissile();
				r.actionKnife();
			} else if(robot instanceof LowRobot) {
				LowRobot r= (LowRobot) robot;
				r.actionFly();
				r.actionMissile();
				r.actionKnife();
			}
		}
		
	}

}
