package com.home.ex1_student;

public class StudentDto {
	private int rank;
	private String sno;
	private String sname;
	private int score;
	private int expel;
	private int mno;
	private String mname;
	
	public StudentDto() {}

	// �����˻�, �л���� : ���, �̸�, �й�, �а���, �а���ȣ, ����
	public StudentDto(int rank, String sno, String sname, int score, int mno, String mname) {
		this.rank = rank;
		this.sno = sno;
		this.sname = sname;
		this.score = score;
		this.mno = mno;
		this.mname = mname;
	}

	// �л��Է� : �й� �̸� ���� ���� �Է� / �л�����
	public StudentDto(String sno, String sname, String mname, int score) {
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	
	@Override
	public String toString() {
		if(rank != 0) {
			return 0 ;
		}
		return super.toString();
	}

	
	
	
	
	
}
