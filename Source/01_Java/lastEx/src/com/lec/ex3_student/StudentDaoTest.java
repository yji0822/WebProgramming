package com.lec.ex3_student;

import java.util.ArrayList;
import java.util.Vector;

public class StudentDaoTest {

	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();
		System.out.println("0.�а��� ����Ʈ");
		Vector<String> mnames = dao.getMNamelist();
		System.out.println(mnames);
		
		System.out.println("1.�й��˻�");
		StudentDto dto = dao.sNogetStudent("20220001");
		System.out.println(dto);
		dto = dao.sNogetStudent("20220002");
		System.out.println(dto);
		
		System.out.println("2.�̸��˻�");
		ArrayList<StudentDto> students = dao.sNamegetStudent("ȫ�浿");
		System.out.println(students);
		
		System.out.println("3.�����˻�");
		students = dao.mNamegetStudent("��ǻ�Ͱ���");
		System.out.println(students);
		
		System.out.println("4.�л��Է�");
		dto = new StudentDto("�׽���", "��ǻ�Ͱ���", 89);
		int result = dao.insertStudent(dto);
		System.out.println(result==StudentDao.SUCCESS? "�Է¼���":"�Է½���");
		
		System.out.println("5. �л�����");
		dto = new StudentDto("20220001", "ȫ�浿", "��ǻ�Ͱ���", 99);
		result = dao.updateStudent(dto);
		System.out.println(result==StudentDao.SUCCESS? "��������":"��������");
		
		System.out.println("6.�л����");
		students = dao.getStudents();
		System.out.println(students);
		
		System.out.println("7.������ ���");
		students = dao.getStudentExpel();
		System.out.println(students);
		
		System.out.println("8. ����ó��(20220001�л�)");
		result = dao.sNoExpel("20220001");
		System.out.println(result==StudentDao.SUCCESS? "����ó������":"����ó������");

	}

}
