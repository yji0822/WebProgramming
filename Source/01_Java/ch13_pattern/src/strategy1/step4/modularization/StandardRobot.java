package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeWood;
import strategy1.step4.interfaces.MissileYes;

public class StandardRobot extends Robot {

	// 외부에서는 안되니까 생성자에서 작성해주자!
	public StandardRobot() {
		setFly(new FlyNo()); // fly = new FlyNo();
		setMissile(new MissileYes()); // missile = new MissileYes();
		setKnife(new KnifeWood()); // knife = new KnifeWood();
	}


}
