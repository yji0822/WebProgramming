package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {

	public static void main(String[] args) {

//		PersonDao dao = new PersonDao(); // �����ڰ� private�� ������ �ȵ�
		PersonDao dao = PersonDao.getinstance();
		
		PersonDto dto = new PersonDto("����", "���", 60, 80, 70);
		
		// 1. �Է� test
		int result = dao.insertPerson(dto);
		System.out.println(result == PersonDao.SUCCESS ? "�Է� ����" : "�Է� ����");
		System.out.println("------------- 2�� test ------------------");

		ArrayList<PersonDto> dtos = dao.selectJname("���"); // 2. ������ ��ȸ test
//		if(dtos.size() != 0)
		if(!dtos.isEmpty()) {
			for(PersonDto d : dtos) {
				System.out.println(d); // toString�������̵� �ؼ� �̷��Ը� �����൵ �ȴ�.
			}
		} else {
			System.out.println("�ش� ������ ����� ��ϵ��� �ʾҽ��ϴ�.");
		}
		
		// 3. ��ü��ȸ test
		System.out.println("---------- 3�� test ------------");

		dtos = dao.selectAll();
		if(dtos.size() != 0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			} // for
		} else {
			System.out.println("��ϵ� ����� �����ϴ�.");
		}
		
		// 4. ������ list - �� ������ �� ó�� ���;� �Ѵ�.
		Vector<String> jnames = dao.jnamelist();
		System.out.println(jnames);

		
	} // main
} // class
