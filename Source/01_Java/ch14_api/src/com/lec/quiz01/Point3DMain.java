package com.lec.quiz01;

public class Point3DMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Point3D p1 = new Point3D();
		System.out.println(p1);
		
		Point3D p2 = new Point3D(2.0, 3.0, 1.0);
		System.out.println(p2);
		
		Point3D p3 = (Point3D) p2.clone();
		System.out.println(p3);
		System.out.println(p2.equals(p3) ? "p1과 p2는 같은 값" : "p1과 p2는 다른 값");
		System.out.println(p2 == p3 ? "복사가 아니고 같은 주소를 가리킴" : "각기 다른 주소를 가리킴");
		
		System.out.println("p2 : " + p2.hashCode());
		System.out.println("p3 : " + p3.hashCode());
	}

}
