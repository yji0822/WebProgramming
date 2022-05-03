package com.lec.quiz01;

public class Point3D implements Cloneable {
//	3D ������ ��ǥ��(x,y,z)�� ���� Point3D Ŭ������ ������ ���ǿ� �°� �����Ͻÿ�
//	��	�Ű������� ���� �ʴ� ������ ȣ��� (x=0.0, y=0.0, z=0.0)
//	�Ű����� 3���� ���� ������ ȣ���  (x,y,z) ������
//	��	x,y,z �Ǽ��� ��ǥ���� ������ true ���� �����ϰ� 
//	�׷��� ������ false�� �����ϴ� equals() ������
//	��	��ǥ�� [x��, y��, z��]�� �����ϴ� toString() ������
//	��	�� ���� ��ǥ��ü�� �����ϴ� clone() ������
//	��	���� �� ������ ��� �����ִ� main()�Լ��� �����ϼ���
	
	private double x;
	private double y;
	private double z;

	// ������
	public Point3D() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// �޼ҵ�
	@Override
		public String toString() {
			return "x = " + x + ", y = " + y + ", z = " + z;
		}
	@Override
		public boolean equals(Object obj) {
			if(obj != null & obj instanceof Point3D) {
				Point3D tempObj = (Point3D)obj;
				boolean xChk = (x == tempObj.x);
				boolean yChk = (y == tempObj.y);
				boolean zChk = (z == tempObj.z);
				return xChk && yChk && zChk;
			} else {
				return false;
			}
		}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	// getter & setter
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
	

}
	
	
	
