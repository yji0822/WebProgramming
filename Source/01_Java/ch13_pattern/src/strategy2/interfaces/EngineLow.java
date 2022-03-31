package strategy2.interfaces;
// 고급엔진
public class EngineLow implements IEngine {

	@Override
	public void engine() {
		System.out.println("저급엔진");
	}

}
