package com.lec.ex3_student;

import java.util.ArrayList;
import java.util.Vector;

public class StudentDaoTest {

	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();
		System.out.println("0.학과명 리스트");
		Vector<String> mnames = dao.getMNamelist();
		System.out.println(mnames);
		
		System.out.println("1.학번검색");
		StudentDto dto = dao.sNogetStudent("20220001");
		System.out.println(dto);
		dto = dao.sNogetStudent("20220002");
		System.out.println(dto);
		
		System.out.println("2.이름검색");
		ArrayList<StudentDto> students = dao.sNamegetStudent("홍길동");
		System.out.println(students);
		
		System.out.println("3.전공검색");
		students = dao.mNamegetStudent("컴퓨터공학");
		System.out.println(students);
		
		System.out.println("4.학생입력");
		dto = new StudentDto("테스터", "컴퓨터공학", 89);
		int result = dao.insertStudent(dto);
		System.out.println(result==StudentDao.SUCCESS? "입력성공":"입력실패");
		
		System.out.println("5. 학생수정");
		dto = new StudentDto("20220001", "홍길동", "컴퓨터공학", 99);
		result = dao.updateStudent(dto);
		System.out.println(result==StudentDao.SUCCESS? "수정성공":"수정실패");
		
		System.out.println("6.학생출력");
		students = dao.getStudents();
		System.out.println(students);
		
		System.out.println("7.제적자 출력");
		students = dao.getStudentExpel();
		System.out.println(students);
		
		System.out.println("8. 제적처리(20220001학생)");
		result = dao.sNoExpel("20220001");
		System.out.println(result==StudentDao.SUCCESS? "제적처리성공":"제적처리실패");

	}

}
