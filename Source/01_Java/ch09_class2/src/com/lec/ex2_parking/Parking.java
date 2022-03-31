package com.lec.ex2_parking;

import java.util.Scanner;

import com.lec.cons.Constant;

// 다음과 같은 결과가 나오도록 클래스를 정의하고 객체를 생성하도록 프로그램을 구현하세요
// 주차장(Parking) 클래스 설계
public class Parking {
	private String no; // 차량번호	
	private int inTime; // 입차시간
	private int outTime; // 출차시간
	private int fee; // 금액
//	private final int HOURLYPARKINGRATE = 2000; 
	// final = 절대 변하지 않는 수 (상수=final변수) - 상수만을 위한 폴더로 이동
	
	// 생성자
	public Parking() {}
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		disp();
//		System.out.println("\"" + no + "\"님, 어서오세요.\n"
//						   + "*입차시간 : " + inTime + "시");
	}
	
	private void disp() {
		System.out.println("\"" + no + "\"님, 어서오세요.\n"
				   + "*입차시간 : " + inTime + "시");
	}
	
	// 메소드
	public void out(int outTime) {
		this.outTime = outTime; // **변수는 private 이기 때문에 지정해주어야 한다.
		fee = (outTime - inTime) * Constant.HOURLYPARKINGRATE; 
		// 출차시간을 메인에 입력받고 계산을 해야하기 때문에 이곳에서 계산을 해주어야 한다.
		if(outTime>inTime) {
		System.out.println("\"" + no + "\"님, 안녕히 가세요.\n"
				+ "*입차시간 : " + inTime +"시"
				+ "\n*출차시간 : " + outTime +"시"
				+ "\n*주차요금 : " + fee + "원\n");
		} else {
			System.out.println("출차시간 오류");
		}
	}
	public void out() {
		// 사용자에게 시간을 입력 받는 것
		Scanner sc = new Scanner (System.in);
		System.out.print("출차 예정 시간: ");
		outTime = sc.nextInt(); // outTime 받아오기
		out(outTime); // 위에있는 함수 출력
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
