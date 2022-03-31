package com.lec.ex2_parking;

public class ParkingTestMain {

	public static void main(String[] args) {
		Parking p = new Parking("11라1111", 12);
		p.out(14);
		
		Parking p1 = new Parking("101루1203", 9);
		p1.out(); // 함수의 오버로딩 사용자에게 outTime 받기		

	}

}
