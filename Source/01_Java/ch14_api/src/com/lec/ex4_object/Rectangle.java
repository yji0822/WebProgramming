package com.lec.ex4_object;
// Rectangle r1 = new Rectangle(10, 5, "����");
// default color = "����"
// Rectangle r1 = new Rectangle();
public class Rectangle implements Cloneable {
	
	private int width;
	private int height;
	private String color;
	
	// ������
	public Rectangle() {
		color = "����"; // �ƹ��͵� �������� �ʾҴٸ� ���� �������� �ڵ� ���� �ǵ���
	}
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		color = "����";
	}
	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	// �޼ҵ�
	@Override
	public String toString() {
//		return "���� " + width + "cm, ���� " + height + "cm�� " + color + "�� �簢��";
		return String.format("���� %dcm, ���� %dcm�� %s�� �簢��", width, height, color);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Rectangle) {
			Rectangle tempObj = (Rectangle)obj;
			boolean widthChk = width == tempObj.width;
			boolean heightChk = height == tempObj.height;
			boolean colorChk = color.equals(tempObj.color); 
			// string�� equals��. �� ��������̶� ����
			return widthChk && heightChk && colorChk;
		} else {
			return false;
		}	
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// ����ó���� �� ���� �ִ� ��� �ǹ�
		return super.clone();
	}
	
	// setter
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
	
	
}
