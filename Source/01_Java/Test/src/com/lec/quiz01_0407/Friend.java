package com.lec.quiz01_0407;
//[ ��I ] Friend Ŭ������ ��ü �迭�� ����� ģ������ �ּ� �� ���� 2�ڸ��� ģ���� �˻��Ͽ�, 
//�����ϴ� ������ ģ���� ��� ģ���� �� ������ ����ϰ�, 
//�������� �ʴ� ������ ģ���� ��� �������� �ʴ� ģ����� ����ϴ� ���α׷��� �����Ͻÿ�(40��).
public class Friend {
	
	// ������
	private String name; // �̸�
	private String phone; // ��ȭ��ȣ
	private String address; // �ּ�
	private String birthday; // ����
	
	// ������
	public Friend() {}
	public Friend(String name, String phone, String address, String birthday) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "�̸� : " + name + "\n�ּ� : " + address 
				+ "\n�ڵ��� : " + phone + "\n���� : " + birthday;
		
	} // toString
	
	// getter&setter
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
