package com.lec.ex09_super;
// name, character / intro() - ��� ���Ե� ����
// Baby b = new Baby("ȫ�ư�", "�̻�"); - �ʱ�ȭ
// Baby b1 = new Baby(); - �ʱ�ȭX
public class Baby extends Person {

	// ������
	public Baby() {
		System.out.println("�Ű����� ���� Baby ������");
	}
	public Baby(String name, String character) {
		super(name, character); // �ݵ�� �� ù�ٿ� ���־�� �Ѵ�!! this(), super(); - ������ ȣ��
//		setName(name);
//		setCharacter(character); // ������ ���� ���
		System.out.println("�Ű����� �ִ� Baby ������");
	}
	
	// method
	@Override
	public void intro() {
		System.out.println("�������� �� �ư���"); // ����ϰ�
		super.intro(); // �� Ŭ������ super�ܿ� �ִ� intro() �����϶� ��
	}
	
	
	
}
