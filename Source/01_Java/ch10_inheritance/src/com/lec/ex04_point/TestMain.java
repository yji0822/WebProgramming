package com.lec.ex04_point;

public class TestMain {

	public static void main(String[] args) {
		
		Point point = new Point(5,5);
		point.setX(10); // 값 변경
		point.pointPrint(); // void형 메소드
		System.out.println(point.infoString()); // String형 메소드
		System.out.println(point);
		System.out.println(point.toString());
		
		Point3D point3d = new Point3D(1,2,3);
		System.out.println(point3d.info3DString());
		System.out.println(point3d.infoString()); // 상속을 받으면 부모 클래스의 메소드, 멤버변수 사용 가능

	}

}
