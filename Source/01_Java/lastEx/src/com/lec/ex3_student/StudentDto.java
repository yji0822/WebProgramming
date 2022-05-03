package com.lec.ex3_student;

public class StudentDto {

	private int rank; // String 할지 말지!
	private String sNo;
	private String sName;
	private int score;
	private int expel;
	private int mNo;
	private String mName;

	// default 생성자
	public StudentDto() {}

	// 입력용 생성자 함수 : sname, jno, score
	public StudentDto(String sName, String mName, int score) {
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}

	// 출력용 : rank, sno, sname, mname(mno), score
	public StudentDto(int rank, String sNo, String sName, String mName, int score) {
		this.rank = rank;
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}

	// 수정용 : sno, sname, jname, score
	public StudentDto(String sNo, String sName, String mName, int score) {
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}

	// 두가지로 분류를 해주어야 한다.
	// 1.rank가 있을 경우 2. 학번이름학과명점수
	@Override
	public String toString() {
		if (rank != 0) {
			return rank + "등\t" + sName + "\t" + mName + "\t" + score +"\n";
		} else {
			return sNo + "\t" + sName + "\t" + mName + "\t" + score + "\n";
		}
	}

	// getter setter
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getExpel() {
		return expel;
	}

	public void setExpel(int expel) {
		this.expel = expel;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

} // class
