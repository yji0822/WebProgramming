package com.lec.ex5_personinfo;

public class PersonInfoTestMain {

	public static void main(String[] args) {
		// int[] arr = new int[2];
//		PersonInfo p1 = new PersonInfo("ȫ�浿", 20, 'm');
//		PersonInfo p2 = new PersonInfo("ȫ���", 19, 'f');
//		PersonInfo[] person = {p1, p2};
		
		// int arr[] = {1,2};
		PersonInfo[] person = new PersonInfo[2];
		person [0] = new PersonInfo("ȫ�浿", 20, 'm');
		person [1] = new PersonInfo("ȫ���", 19, 'f');
		System.out.println("�迭�� �̿��� ���");
//		PersonInfo[] person = {new PersonInfo("ȫ�浿", 20, 'm'),
//							   new PersonInfo("ȫ���", 19, 'f')};
		for(int idx=0; idx<person.length; idx++) {
			person[idx].print();		
		}
							
		System.out.println("Ȯ�� for��");
		for(PersonInfo p : person) {
			p.print();
		}
	}

}
