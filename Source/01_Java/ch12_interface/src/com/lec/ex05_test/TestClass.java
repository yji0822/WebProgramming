package com.lec.ex05_test;
// i1, i2, i3, m1(�߻�), m2(�߻�), m3(�߻�)
// i1, i2, i3, m1(�Ϲ�), m2(�Ϲ�), m3(�Ϲ�)
public class TestClass implements I3 {

	@Override
	public void m1() {	
		System.out.println("��� i1 = " + i1); // I1.i1
	}

	@Override
	public void m2() {
		System.out.println("��� i2 = " + i2); // I2.i2
	}

	@Override
	public void m3() {
		System.out.println("��� i3 = " + i3); // I3.i3
	}

}
