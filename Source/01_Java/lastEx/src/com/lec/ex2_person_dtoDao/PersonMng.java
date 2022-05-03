package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		PersonDao dao = PersonDao.getinstance();
		
		String fn;
		ArrayList<PersonDto> dtos; // return 받을 친구임
		
		do {
			System.out.println("1. 입력  | 2. 직업별조회  |  3. 전체조회  | 그 외는 종료 ");
			
			fn = sc.next();
			switch(fn) {
			case "1": // 1. 데이터 입력 : 이름, 직업명, 국, 영, 수 입력
				System.out.println("입력");
				System.out.println("입력할 이름은?!  ");
				String pname = sc.next();
				System.out.println("직업(배우|가수)은?  ");
				String jname = sc.next();
				System.out.print("국어점수 :  ");
				int kor = sc.nextInt();
				System.out.println("영어점수 :  ");
				int eng = sc.nextInt();
				System.out.println("수학점수 :  ");
				int mat = sc.nextInt();
				
				int result = dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				System.out.println(result == PersonDao.SUCCESS ? "입력 성공!" : "입력 실패..");
				
				break;
				
			case "2": // 2. 직업 입력 받은 후 조회
				System.out.println("직업별 조회");
				jname = sc.next();
				dtos = dao.selectJname(jname);
				if(dtos.isEmpty()) {
					System.out.println("해당 직업에  사람이 없습니다.");
				} else {
					System.out.println("rank\t이름\t\t직업명\t국어\t영어\t수학\t합계");
					for(PersonDto d : dtos){
						System.out.println(d);
					} // for
				} // if-else
				
			case "3":
				System.out.println("전체 조회");
				dtos = dao.selectAll();
				if(dtos.size() != 0) {
					System.out.println("rank\t이름\t\t직업명\t국어\t영어\t수학\t합계");
					for(PersonDto d : dtos) {
						System.out.println(d);
					} // for
				} else {
					System.out.println("등록된 사람이 없습니다.");
				}
				
			} // switch-case
			
			
		} while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("BYE");
		
	} // main
} // class
