package com.lec.ex2_person_dtoDao;

public class PersonDto {
	private int rank;
	private String pname;
	private String jname;
	private int kor;
	private int eng;
	private int mat;
	private int sum;

	// 디폴트 생성자
	public PersonDto() {}

	// 입력용 생성자 함수: pname, jname, kor, eng, mat
	public PersonDto(String pname, String jname, int kor, int eng, int mat) {
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	// 출력용 생성자 함수 : rank, pame, jname, kor, eng, mat, sum
	public PersonDto(int rank, String pname, String jname, int kor, int eng, int mat, int sum) {
		this.rank = rank;
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = sum;
	}

	// toString - 출력 형식 : 1등 송혜교(5번) 배우 100 100 100 300
	// 어떻게 출력이 되는지 확인을 해서라도 toString은 무조건 만든다고 보면 된다.
	@Override
	public String toString() {
		return rank + "등\t" + pname + (pname.length() < 6 ? "\t\t" : "\t") + jname + "\t" + kor + "\t" + eng + "\t"
				+ mat + "\t" + sum;
	}

	// getter & setter
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	// 드라이버는 로드한 상태이기 때문에 닫아주지 않아도 된다.

}
