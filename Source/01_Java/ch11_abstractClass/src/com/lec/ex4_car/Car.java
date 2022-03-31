package com.lec.ex4_car;
// Car : color, tire, displacement, handle, getSpec()
public abstract class Car {
	
	private String color;
	private String tire; // Ÿ�̾�
	private int displacement; // ��ⷮ
	private String handle; // �ڵ�
	
	// ������
	public Car(String color, String tire, int displacement, String handle) {
		super();
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	
	// �޼ҵ�
	public abstract void getSpec(); // �߻�޼ҵ� - �������� �ٸ� Ŭ�������� ������ �ض�!

	public String getColor() {
		return color;
	}

	// getter&setter
	public void setColor(String color) {
		this.color = color;
	}

	public String getTire() {
		return tire;
	}

	public void setTire(String tire) {
		this.tire = tire;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	

}
