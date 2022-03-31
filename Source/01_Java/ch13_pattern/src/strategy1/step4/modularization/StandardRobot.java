package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeWood;
import strategy1.step4.interfaces.MissileYes;

public class StandardRobot extends Robot {

	// �ܺο����� �ȵǴϱ� �����ڿ��� �ۼ�������!
	public StandardRobot() {
		setFly(new FlyNo()); // fly = new FlyNo();
		setMissile(new MissileYes()); // missile = new MissileYes();
		setKnife(new KnifeWood()); // knife = new KnifeWood();
	}


}
