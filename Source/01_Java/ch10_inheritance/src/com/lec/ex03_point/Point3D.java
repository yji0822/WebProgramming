package com.lec.ex03_point;
// Point3D p1 = new Point3D(20, 10, 5);
// p1.pointPrint();
public class Point3D extends Point {
	private int z;
	
	// ������ 
	public Point3D(){
		
	}
	public Point3D(int x, int y, int z) {
		setX(x);
		setY(y);
		this.z = z;
	}
	
	// �޼ҵ�
	public void point3DPrint() {
		System.out.println("3���� ��ǥ : x = " + getX() + "y = " + getY() + "z = " + z);
	}
	public String info3DString() {
		return "3���� ��ǥ : x = " + getX() + ", y = " + getY() + ", z = " + z;
	}
	
	// getter&setter
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}
