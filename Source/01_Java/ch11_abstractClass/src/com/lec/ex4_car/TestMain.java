package com.lec.ex4_car;

import com.lec.cons.CarSpec;

public class TestMain {

	public static void main(String[] args) {
		// 가독성
		//		Car car = new LowGradeCar("회색", "일반타이어", 1000, "일반");
		// LowGradeCar
		/* Car car = new LowGradeCar(CarSpec.GRAY_CAR, CarSpec.TIRE_NOMAL, 
				CarSpec.DISPLACEMENT_1000, CarSpec.HANDDLE_NORMAL);
		car.getSpec(); */
		
		Car car = new HighGradeCar(CarSpec.WHITE_CAR, CarSpec.TIRE_WIDE, 
				CarSpec.DISPLACEMENT_2200, CarSpec.HANDDLE_POWER);
		car.getSpec();

	}

}
