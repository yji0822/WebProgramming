package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileNo;

public class LowRobot extends Robot {
	// »ý¼ºÀÚ
	public LowRobot() {
		setFly(new FlyNo()); // fly = new FlyNo();
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}
	
}
