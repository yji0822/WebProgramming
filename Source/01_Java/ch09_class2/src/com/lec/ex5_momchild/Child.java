package com.lec.ex5_momchild;
// Child first = new Child("ù°");
// first.takeMoney(1000); // ���� õ����
public class Child {
	
	private String name; // ��ü������
	static MomPouch momPouch; // static - 
//	��ǰ���� ������ product serial no. �� �ٸ��� Ȯ���ϰ� ���� ��. 
//	MomPouch momPouch; // ����Ʈ. ��ü������
//	MomPouch momPouch = new MomPouch(); �� ����
	// ������
	public Child() {}
	public Child(String name) {
		this.name = name;
		momPouch = new MomPouch();
	}
	// �޼ҵ�
	public void takeMoney(int money) { // int money - �ڽ��� �޶�� ��
		if(momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name + "�� " + money + "�� �������� ���� �������� "
					+ momPouch.money + "���� �����ִ�.");
		} else {
			System.out.println(name + "�� ���� �� ����. ���� ���� �������� " 
					+ momPouch.money + "�� �����ִ�.");
		} // if-else
	} // takeMoney
		
} // Child class