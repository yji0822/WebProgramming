package com.lec.ch02.ex4_vehicle;

import lombok.Data;

@Data
public class VehicleImpl implements Vehicle {

	private String vehicle; // 타는 것
	private int speed; // 속도
	
	public void ride(String name) {
		System.out.println(name + "은(는) " + vehicle + "를(을) " + speed + "km/h로 타고 가는 중입니다.");
	}

}
