package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeLazer;
import strategy1.step4.interfaces.MissileYes;

public class SuperRobot extends Robot {

	public SuperRobot() { // 积己磊俊辑 按眉 积己
		setFly(new FlyYes()); //fly = new FlyYes();
		setMissile(new MissileYes()); // missile = new MissileYes;
		setKnife(new KnifeLazer()); // knife = new KnifeLazer();
	}


	

}
