package com.lec.quiz04_customer;

public class CustomerDto {
	
	private int cno;
	private String ctel;
	private String cname;
	private int cpoint;
	
	// default ������
	public CustomerDto() {}

	// �Է¿�
	public CustomerDto(String ctel, String cname, int cpoint) {
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
	}

	// ��¿�
	public CustomerDto(int cno, String ctel, String cname, int cpoint) {
		this.cno = cno;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
	}
	
	// tostring
	@Override
	public String toString() {
		return cno + "    " + ctel + "\t" + cname + "\t" + cpoint + "\n";
	}

	// getter
	public int getCno() {
		return cno;
	}

	public String getCname() {
		return cname;
	}

	public String getCtel() {
		return ctel;
	}

	public int getCpoint() {
		return cpoint;
	}
	
	
	
	
}
