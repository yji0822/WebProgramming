package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {

	public static void main(String[] args) {

//		PersonDao dao = new PersonDao(); // 생성자가 private기 때문에 안됨
		PersonDao dao = PersonDao.getinstance();
		
		PersonDto dto = new PersonDto("김길순", "배우", 60, 80, 70);
		
		// 1. 입력 test
		int result = dao.insertPerson(dto);
		System.out.println(result == PersonDao.SUCCESS ? "입력 성공" : "입력 실패");
		System.out.println("------------- 2번 test ------------------");

		ArrayList<PersonDto> dtos = dao.selectJname("배우"); // 2. 직업별 조회 test
//		if(dtos.size() != 0)
		if(!dtos.isEmpty()) {
			for(PersonDto d : dtos) {
				System.out.println(d); // toString오버라이드 해서 이렇게만 적어줘도 된다.
			}
		} else {
			System.out.println("해당 직업에 사람이 등록되지 않았습니다.");
		}
		
		// 3. 전체조회 test
		System.out.println("---------- 3번 test ------------");

		dtos = dao.selectAll();
		if(dtos.size() != 0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			} // for
		} else {
			System.out.println("등록된 사람이 없습니다.");
		}
		
		// 4. 직업명 list - 빈 공백이 맨 처음 나와야 한다.
		Vector<String> jnames = dao.jnamelist();
		System.out.println(jnames);

		
	} // main
} // class
