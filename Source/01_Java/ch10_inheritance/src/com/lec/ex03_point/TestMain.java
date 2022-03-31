package com.lec.ex03_point;

public class TestMain {

	public static void main(String[] args) {
		Point point = new Point(5, 5); // setting
		point.setX(10);
		
		point.pointPrint();
		System.out.println(point.infoString());
		
		// *** �̷� ��� ���� ����Ѵ�! ��
		System.out.println(point); // Object�� toString()ȣ��
		System.out.println(point.toString());
		
		Point3D point3d = new Point3D(1,2,3); // setting
		System.out.println(point3d.info3DString());
		System.out.println(point3d.infoString()); // ����� ������ ��� ����� �޼ҵ� �� ���
		
	}

}
