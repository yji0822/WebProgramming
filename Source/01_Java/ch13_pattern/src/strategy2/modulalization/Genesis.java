package strategy2.modulalization;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km10;

// 상속받은 멤버 : 3가지 부품 변수 (데이터) & 메소드 drive(일반), shape(추상), engine(중급...고급.. 일반메소드), km(일반), fuel(일반), setter
// 생성자 세팅 & 추상클래스 
public class Genesis extends Car {
	
	// 생성자
	public Genesis() {
		setEngine(new EngineHigh()); // engine = new EngineHigh();
		setKm(new Km10()); // km = new Km10();
		setFuel(new FuelGasoline()); // fuel = new FuelGasoline();
	}
	
	@Override
	public void shape() {
		System.out.println("제네시스 모양은 door, sheet, handle 로 이루어져 있습니다.");
	}

}
