package com.lec.quiz01;

public class Point3D implements Cloneable {
//	3D 공간의 좌표값(x,y,z)을 갖는 Point3D 클래스를 다음의 조건에 맞게 구현하시오
//	①	매개변수를 갖지 않는 생성자 호출시 (x=0.0, y=0.0, z=0.0)
//	매개변수 3개를 갖는 생성자 호출시  (x,y,z) 값으로
//	②	x,y,z 실수의 좌표값이 같으면 true 값을 리턴하고 
//	그렇지 않으면 false를 리턴하는 equals() 재정의
//	③	좌표값 [x값, y값, z값]을 리턴하는 toString() 재정의
//	④	똑 같은 좌표객체를 복사하는 clone() 재정의
//	⑤	위의 네 조건을 모두 보여주는 main()함수를 구현하세요
	
	private double x;
	private double y;
	private double z;

	// 생성자
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
	
	// 메소드
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
	
	
	
