package com.lec.ex3_shape;
// Shape�� ���� Rect(height, width), Traiangle(w, h), Circle(r)�� �� ������ ��
public abstract class Shape { // �߻�Ŭ���� - ���� ������ Ʋ�� ������شٰ� �����ϸ� ��
	// ������X
	// �޼ҵ�
	public void draw() {
		String className = this.getClass().getName(); // com.lec.ex3_shape.Circle
		// -> Circle�� ������
		System.out.println(this.getClass().getName() + "������ �׷���");
		// �� ��ü�� Ŭ������ �����ͼ� �� Ŭ������ �̸��� �ѷ���! ��� �ǹ�
	}
	
	public abstract double computerArea(); // �߻�޼ҵ� 
	// �簢������ �ﰢ������ �������� ����ϴ� ���� �� childclass���� Ȯ���ض�

}
