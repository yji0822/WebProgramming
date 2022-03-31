package strategy1.step5.modularization;

public abstract class Robot {
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}
	public void actionRun() {
		System.out.println("달릴 수 있습니다.");
	}
	public void Shape() {
		String className = getClass().getName(); // 클래스 이름 가져오는 메소드
		// stragegy1.step2.superRobot 
		// 맨 마지막 찍힌 점의 위치
		int idx = className.lastIndexOf('.'); // 맨마지막'.'의 위치를 정수로 리턴해준다
		String name = className.substring(idx+1); // idx+1번째 글씨부터 끝까지
		System.out.println(name + "입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.");
	} 
	// 공통된 메소드 선언만 해놓기
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
}
