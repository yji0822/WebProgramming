package strategy2.modulalization;
// 3가지 부품 변수 (데이터) & 생성자X & 메소드 drive(일반), shape(추상), engine(중급...고급.. 일반메소드), km(일반), fuel(일반), setter

import strategy2.interfaces.IEngine;
import strategy2.interfaces.IFuel;
import strategy2.interfaces.IKm;

public abstract class Car {
	
	private IEngine engine; // 3가지 부품 변수
	private IKm		km;
	private IFuel	fuel;
	
	public void drive() {
		System.out.println("드라이브 할 수 있습니다.");
	}
	public abstract void shape(); // 추상
	public void engine() {
		engine.engine();
	}
	public void km() {
		km.km();
	}
	public void fuel() {
		fuel.fuel();
	}
	
	// setter
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}
	public void setKm(IKm km) {
		this.km = km;
	}
	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}
	
	
}
