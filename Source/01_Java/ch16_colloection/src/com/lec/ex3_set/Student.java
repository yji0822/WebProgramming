package com.lec.ex3_set;

public class Student {
	
	private int grade;
	private String name;
	
	// ������
	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}
	
	// �޼ҵ�
	@Override
	public String toString() {
		return grade + "�г� " + name;
	}

	// equals & hashcode �������̵�
	@Override
	public boolean equals(Object obj) { // api object �������̵� �����ϱ�
		if(obj != null && obj instanceof Student) {
//			boolean gradeChk = grade == ((Student)obj).grade;
//			boolean nameChk = name.equals(((Student)obj).name);
//			return gradeChk && nameChk;
			return toString().equals(obj.toString()); 
			// grade+"�г�"+name; �̶� obj�� tostring�� ������ ���ٰ� ���.
		}
		return false;
	}
	@Override
	public int hashCode() {
		return toString().hashCode(); // ��µ� ���� �Ȱ����� ���� hashCode()�� ����ϵ���
	}
	
	

}
