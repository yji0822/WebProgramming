package com.lec.ex3_student;

public class StudentDto {

	private int rank; // String ���� ����!
	private String sNo;
	private String sName;
	private int score;
	private int expel;
	private int mNo;
	private String mName;

	// default ������
	public StudentDto() {}

	// �Է¿� ������ �Լ� : sname, jno, score
	public StudentDto(String sName, String mName, int score) {
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}

	// ��¿� : rank, sno, sname, mname(mno), score
	public StudentDto(int rank, String sNo, String sName, String mName, int score) {
		this.rank = rank;
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}

	// ������ : sno, sname, jname, score
	public StudentDto(String sNo, String sName, String mName, int score) {
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}

	// �ΰ����� �з��� ���־�� �Ѵ�.
	// 1.rank�� ���� ��� 2. �й��̸��а�������
	@Override
	public String toString() {
		if (rank != 0) {
			return rank + "��\t" + sName + "\t" + mName + "\t" + score +"\n";
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
