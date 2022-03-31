package com.lec.ex1_string;

public class Ex08_Friend {
	private String name;
	private String phone;
	private String birthday;
	
	public Ex08_Friend(String name, String phone, String birthday) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "이   름 : " + name + "\n핸드폰 : " + phone + "\n생   일 : " + birthday ;
	}
	
	// getter&setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
