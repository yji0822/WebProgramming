package com.lec.ex03_point;

public class TestMain {

	public static void main(String[] args) {
		Point point = new Point(5, 5); // setting
		point.setX(10);
		
		point.pointPrint();
		System.out.println(point.infoString());
		
		// *** 이런 경우 많이 사용한다! ↓
		System.out.println(point); // Object의 toString()호출
		System.out.println(point.toString());
		
		Point3D point3d = new Point3D(1,2,3); // setting
		System.out.println(point3d.info3DString());
		System.out.println(point3d.infoString()); // 상속을 받으면 모든 멤버와 메소드 다 상속
		
	}

}
