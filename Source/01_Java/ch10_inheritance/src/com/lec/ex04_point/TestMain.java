package com.lec.ex04_point;

public class TestMain {

	public static void main(String[] args) {
		
		Point point = new Point(5,5);
		point.setX(10); // �� ����
		point.pointPrint(); // void�� �޼ҵ�
		System.out.println(point.infoString()); // String�� �޼ҵ�
		System.out.println(point);
		System.out.println(point.toString());
		
		Point3D point3d = new Point3D(1,2,3);
		System.out.println(point3d.info3DString());
		System.out.println(point3d.infoString()); // ����� ������ �θ� Ŭ������ �޼ҵ�, ������� ��� ����

	}

}
