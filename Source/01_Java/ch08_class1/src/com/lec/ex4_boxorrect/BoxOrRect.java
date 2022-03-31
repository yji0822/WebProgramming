package com.lec.ex4_boxorrect;
/* (�ǽ�����2) ������ü�� ����, ����, ����, ���ǳ� ���簢���� ����, ����, ���̸� �Ӽ����� ���� Ŭ������ �����϶�. ���ǳ� ���̸� �����ϴ� �޼ҵ� getVolume(), ����ϴ� �޼ҵ� vPrint()�� �����Ѵ�.
����, ���θ� ������ ���簢������ �ν�
������: ����, ����, ����, area(���� or ����)
�޼ҵ� : int getVolume(), void vPrint() */
public class BoxOrRect {
	private int width;
	private int height;
	private int depth; // box�� ��� ����, rect�� ��� 0 ���
	private int volume; // box�� ��� ����, rect�� ��� ����
	
	// ������
	public BoxOrRect() {}
	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		volume = width * height;
	} // rect������
	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width*height*depth;
	} // box������
	
	// method
	public int getVolume() {
		return volume;
	}
	public void vPrint(){
		if(depth!=0) { // box
		System.out.println("���Ǵ� " + volume + "cm3");
		} else { // rect
			System.out.println("���̴� " + volume + "cm2");
		}
	} // ȭ�鿡 ������ִ� �Լ�
	
	
	

	
}
