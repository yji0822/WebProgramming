// �̷��� ���� �ȵȴ�. �ڹ� ���Ͽ��� �ݵ�� �Ѱ����� public class
// �ڹ� ���� �ϳ��� �ϳ��� Ŭ���� ������ֱ�.
package com.lec.ex0_janmuri;

class PersonInfo{
	private String name;
	private int age;
	public PersonInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void print() {
		System.out.printf("�̸� = %s, ���� = %d��\n", name, age);
	}
}


public class PersonInfoTestMain {

	public static void main(String[] args) {
		PersonInfo[] person = {new PersonInfo("ȫ�浿", 22),
				new PersonInfo("�ű浿", 33)};
		for (PersonInfo p : person) {
			p.print();
		}
		for(int idx=0; idx<person.length; idx++) {
			person[idx].print();
		}

	}

}
