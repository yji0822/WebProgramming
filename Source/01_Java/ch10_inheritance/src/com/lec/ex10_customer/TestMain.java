package com.lec.ex10_customer;

public class TestMain {

	public static void main(String[] args) {
		
		Customer customer = new Customer("ȫ", "010-9999-9999", "�����", "1995-01-01"); // ȫ�� �����մϴ�. ����Ʈ 1000���� ������ �帳�ϴ�.
		customer.buy(100000); // ȫ�� �������ּż� �����մϴ�. ��������Ʈ: 5000, �� �����Ͻ� ����Ʈ: 6000
		customer.buy(900000); // ȫ�� �������ּż� �����մϴ�. ��������Ʈ: 45000, �� �����Ͻ� ����Ʈ: 51000 \n ȫ�� VIP������ ���׷��̵� �Ǽ̽��ϴ�.
		System.out.println(customer.infoString()); // [�̸�] ȫ [��ȭ] 010-9999-9999 [�ּ�] ����� [����Ʈ] 51000 [�����ݾ�] 1000000
		
		System.out.println();
		Staff staff = new Staff("��", "010-1234-5678", "2022-09-01", "������");
		Person person = new Person("��", "010-7890-1234");
		// Staff�� Person Ÿ���̴�. (�ΰ������� �����̴�)
		
		// person �迭
		Person[] personArr = {customer, staff, person};
		
		System.out.println("�Ϲ� for��");
		for(int i=0; i<personArr.length; i++) {
			System.out.println(personArr[i].infoString());
		}
		// �迭0~������� infoString()
		System.out.println("Ȯ�� for��");
		for(Person p : personArr) {
			System.out.println(p.infoString());
		}
		
		// buy(1000) - Ȯ��for��
		for(Person p : personArr) {
			if(p instanceof Customer) { // p ������ Customer�� ��ü(instance)�ΰ�?
			((Customer)p).buy(1000); 
			} else {
				System.out.println("buy�� Customer�� �����մϴ�.");
			} // if-else
		} // for
		

	} // main

} // class
