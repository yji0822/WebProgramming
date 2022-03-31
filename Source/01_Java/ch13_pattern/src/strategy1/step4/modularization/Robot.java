package strategy1.step4.modularization;

import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;

public abstract class Robot { // 객체 못만듦 abstract함수가 없어도 사용은 가능 
	// Robot r = new Robot();
	// r.actionFly(); - 생성자에서 fly=new FlyNo() 이런걸 하지 않았기 때문에 에러.
	// 이를 방지하고자 객체 생성 불가 하도록 abstract class로 만들어 놓는다.
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}
	public void actionRun() {
		System.out.println("달릴 수 있습니다.");
	}
	public void shape() {
		String className = getClass().getName(); // 클래스 이름 가져오는 메소드
		// stragegy1.step2.superRobot 
		// 맨 마지막 찍힌 점의 위치
		int idx = className.lastIndexOf('.'); // 맨마지막'.'의 위치를 정수로 리턴해준다
		String name = className.substring(idx+1); // idx+1번째 글씨부터 끝까지
		System.out.println(name + "입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.");
	} 
	// 공통된 메소드 선언만 해놓기
	public void actionFly() {
		fly.fly();
	}
	public void actionMissile() {
		missile.missile();
	}
	public void actionKnife() {
		knife.knife();
	}
	
	// Setter
	public void setFly(IFly fly) {
		this.fly = fly;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
	
	
}
