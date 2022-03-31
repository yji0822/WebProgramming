package com.lec.ex2_parking;

import java.util.Scanner;

import com.lec.cons.Constant;

// ������ ���� ����� �������� Ŭ������ �����ϰ� ��ü�� �����ϵ��� ���α׷��� �����ϼ���
// ������(Parking) Ŭ���� ����
public class Parking {
	private String no; // ������ȣ	
	private int inTime; // �����ð�
	private int outTime; // �����ð�
	private int fee; // �ݾ�
//	private final int HOURLYPARKINGRATE = 2000; 
	// final = ���� ������ �ʴ� �� (���=final����) - ������� ���� ������ �̵�
	
	// ������
	public Parking() {}
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		disp();
//		System.out.println("\"" + no + "\"��, �������.\n"
//						   + "*�����ð� : " + inTime + "��");
	}
	
	private void disp() {
		System.out.println("\"" + no + "\"��, �������.\n"
				   + "*�����ð� : " + inTime + "��");
	}
	
	// �޼ҵ�
	public void out(int outTime) {
		this.outTime = outTime; // **������ private �̱� ������ �������־�� �Ѵ�.
		fee = (outTime - inTime) * Constant.HOURLYPARKINGRATE; 
		// �����ð��� ���ο� �Է¹ް� ����� �ؾ��ϱ� ������ �̰����� ����� ���־�� �Ѵ�.
		if(outTime>inTime) {
		System.out.println("\"" + no + "\"��, �ȳ��� ������.\n"
				+ "*�����ð� : " + inTime +"��"
				+ "\n*�����ð� : " + outTime +"��"
				+ "\n*������� : " + fee + "��\n");
		} else {
			System.out.println("�����ð� ����");
		}
	}
	public void out() {
		// ����ڿ��� �ð��� �Է� �޴� ��
		Scanner sc = new Scanner (System.in);
		System.out.print("���� ���� �ð�: ");
		outTime = sc.nextInt(); // outTime �޾ƿ���
		out(outTime); // �����ִ� �Լ� ���
		sc.close();
	}

	
	// getter&setter
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getInTime() {
		return inTime;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	public int getOutTime() {
		return outTime;
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}

}
