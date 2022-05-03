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

	// 전공검색, 학생출력 : 등수, 이름, 학번, 학과명, 학과번호, 점수
	public StudentDto(int rank, String sno, String sname, int score, int mno, String mname) {
		this.rank = rank;
		this.sno = sno;
		this.sname = sname;
		this.score = score;
		this.mno = mno;
		this.mname = mname;
	}

	// 학생입력 : 학번 이름 전공 점수 입력 / 학생수정
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
