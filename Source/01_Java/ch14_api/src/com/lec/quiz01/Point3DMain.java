package com.lec.quiz01;

public class Point3DMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Point3D p1 = new Point3D();
		System.out.println("p1 : " + p1);
		
		Point3D p2 = new Point3D(2.0, 3.0, 1.0);
		System.out.println("p2 : " + p2);
		
		Point3D p3 = (Point3D) p2.clone();
		System.out.println("p3 : " + p3);
		
		System.out.println(p2.equals(p3) ? "p2�� p3�� ���� ��" : "p2�� p3�� �ٸ� ��"); // p1�� p2�� ���� ��
		System.out.println(p2 == p3 ? "���簡 �ƴϰ� ���� �ּҸ� ����Ŵ" : "���� �ٸ� �ּҸ� ����Ŵ"); // ���� �ٸ� �ּҸ� ����Ŵ
		
		System.out.println("p2 : " + p2.hashCode()); // p2 : 366712642
		System.out.println("p3 : " + p3.hashCode()); // p3 : 1829164700
	}

}
