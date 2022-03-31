package strategy1.step4.interfaces;
// 높이 고공 비행하도록 수정한 
public class FlyHigh implements IFly {

	@Override
	public void fly() {
		System.out.println("높이 고공 비행합니다.");
	}

}
