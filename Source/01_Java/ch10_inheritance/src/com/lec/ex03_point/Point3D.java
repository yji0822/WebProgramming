package com.lec.ex03_point;
// Point3D p1 = new Point3D(20, 10, 5);
// p1.pointPrint();
public class Point3D extends Point {
	private int z;
	
	// 생성자 
	public Point3D(){
		
	}
	public Point3D(int x, int y, int z) {
		setX(x);
		setY(y);
		this.z = z;
	}
	
	// 메소드
	public void point3DPrint() {
		System.out.println("3차원 좌표 : x = " + getX() + "y = " + getY() + "z = " + z);
	}
	public String info3DString() {
		return "3차원 좌표 : x = " + getX() + ", y = " + getY() + ", z = " + z;
	}
	
	// getter&setter
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}
