package com.lec.ex4_boxorrect;

public class BoxOrRectTestMain {

	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5, 6, 10);
		BoxOrRect rect = new BoxOrRect(10, 5);
		box.vPrint(); // box ���� ���
		rect.vPrint(); // ���簢�� ���� ���
		System.out.println("box ���Ǵ� " + box.getVolume());
		System.out.println("rect ���̴� " + box.getVolume());
		
	}

}
