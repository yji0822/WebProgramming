package com.lec.quiz01;

public class Point3DMain {

	public static void main(String[] args) {
		
		Point3D p1 = new Point3D();
		System.out.println(p1);
		Point3D p2 = new Point3D(2.0, 3.0, 1.0);
		System.out.println(p2);
		
		Point3D p3 = (Point3D) p2.clone();

	}

}
