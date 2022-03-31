package com.lec.ex2_human;
// Man kim = new Man (22, 160, 50.2, "010-4444-5555"); - ������ 4�� ��� �ʱ�ȭ
// Man kim = new Man (22, 160, 50.2); - ������3��. ��ȭ��ȣ�� �Է����� �ʾƵ� �ǵ���

public class Man {
	private int age; // ����
	private int height; // Ű 
	private double weight; // ������
	private String phoneNum; // �ڵ�����ȣ

	// ������
	public Man() {} // ����Ʈ ������ �Լ�
	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		System.out.println("�Ķ���Ͱ� 4��¥�� ������ �Լ� ȣ��");	
	}
	
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;	
		System.out.println("�Ķ���Ͱ� 3��¥�� ������ �Լ� ȣ��");	
	}
	// ���� ���� �ڷ����� ���� �и��ؼ� �����ڸ� ���� �� ����.
	// �Ű������� ������ �Լ��� �����ε��� �з��ϱ� ������!
	public Man(int age) {
		this.age = age;
	} // �� ��ü �ȿ� �ִ� age
//	public Man(int height) {
//		this.height = height;
//	} // ���Ұ�
	
	// �޼ҵ�(�Լ�)
	public double calculateBMI() {
		double result = weight / ((height/100.0) * (height/100.0));
		return result;
	} // BMI ������ִ� �޼ҵ�(�Լ�)
	
	// setter&getter (age, height, weight, phoneNum)
	public void setAge(int age) {
		this.age = age; // this. - "�� ��ü ����" ��� �ǹ� 
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	// getter m.getAge() age�� ����? �ϰ� ��������  m.setAge(22)
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
		
	
	
}
