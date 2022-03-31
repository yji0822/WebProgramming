package com.lec.ex10_customer;
// name, tel - person (super class)
// address, sum, point, date(�����), vip
// Customer c = new Customer("ȫ", "010", "��", "1995-12-12");
// vip�� false�� �����ϰ�, point=1000;

public class Customer extends Person { // �Ű��������� �����ڰ� ��� ������ �߻���

	private String address;
	private int    sum; // ���Ŵ����ݾ� - vip�� ���ؿ��� �����ϴ���
	private int    point; // ����Ʈ(���Ÿ��� 5% ����) / �Ҽ��� ������ ���� 
	private String date; // ����� (����, DateŸ���� �� ����)	
	private boolean vip; // ture�� vip, false�� �Ϲ�	
	
	// ������
	public Customer(String name, String tel, String address, String date) {
		super(name, tel); // Person����  �ҷ����� - ������ ù��° ��!!!!
		this.address = address;
		this.date = date;
		point = 1000; // �� �����Դ� 1000 ����Ʈ �ڵ��ο�
		// sum = 0; or vip = false; // �̹� �ڵ����� �ʱ�ȭ �� ���̶� �����Ƿ� ���� ����
		System.out.println(name +"�� �����մϴ�. ����Ʈ 1000���� ������ �帳�ϴ�.");
	}
	
	// �޼ҵ�
	public void buy(int price) { // c.buy(10000)
		sum += price;
		int tempPoint = (int)(price * 0.05); // ����ȯ!
		point += tempPoint;
		System.out.println(getName() + "�� �������ּż� �����մϴ�. ��������Ʈ: " + tempPoint
								+ ", �� �����Ͻ� ����Ʈ: " + point);
		if(sum >=1000000 && vip==false) { // sum�� 100���� �̻��̰�, vip�� �ƴѰ�쿡��
			vip = true; // ���Ŵ����ݾ��� 100���� �̻� ��, vip������
			System.out.println(getName() + "�� VIP������ ���׷��̵� �Ǽ̽��ϴ�.");
		} //if
	} // buy
	
	
	// c.print() vs. sysout(c.infoString()) vs. sysout(c)
	@Override // @: ������̼� - ��ǻ�Ϳ��Ը� �˷��ִ� ����. �ٷ� ���ٸ� ������ �ش�.
	public String infoString() {
		return super.infoString() + " [�ּ�] " + address + " [����Ʈ] " + point + " [�����ݾ�] " + sum; 
		// person()�� infoString() ��� - [�̸�]ȫ [��ȭ] 010-999-9999
	}
	
	

}
