package com.lec.ex10_customer;
// name, tel - person (super class)
// address, sum, point, date(기념일), vip
// Customer c = new Customer("홍", "010", "설", "1995-12-12");
// vip는 false로 시작하고, point=1000;

public class Customer extends Person { // 매개변수없는 생성자가 없어서 에러가 발생됨

	private String address;
	private int    sum; // 구매누적금액 - vip의 기준에도 부합하는지
	private int    point; // 포인트(구매마다 5% 적립) / 소수점 절삭할 것임 
	private String date; // 기념일 (추후, Date타입이 될 것임)	
	private boolean vip; // ture면 vip, false면 일반	
	
	// 생성자
	public Customer(String name, String tel, String address, String date) {
		super(name, tel); // Person에서  불러오기 - 무조건 첫번째 줄!!!!
		this.address = address;
		this.date = date;
		point = 1000; // 새 고객에게는 1000 포인트 자동부여
		// sum = 0; or vip = false; // 이미 자동으로 초기화 된 값이랑 같으므로 적지 않음
		System.out.println(name +"님 감사합니다. 포인트 1000점을 선물로 드립니다.");
	}
	
	// 메소드
	public void buy(int price) { // c.buy(10000)
		sum += price;
		int tempPoint = (int)(price * 0.05); // 형변환!
		point += tempPoint;
		System.out.println(getName() + "님 구매해주셔서 감사합니다. 적립포인트: " + tempPoint
								+ ", 총 보유하신 포인트: " + point);
		if(sum >=1000000 && vip==false) { // sum이 100만원 이상이고, vip가 아닌경우에만
			vip = true; // 구매누적금액이 100만원 이상 시, vip고객으로
			System.out.println(getName() + "님 VIP고객으로 업그레이드 되셨습니다.");
		} //if
	} // buy
	
	
	// c.print() vs. sysout(c.infoString()) vs. sysout(c)
	@Override // @: 어노테이션 - 컴퓨터에게만 알려주는 역할. 바로 밑줄만 영향을 준다.
	public String infoString() {
		return super.infoString() + " [주소] " + address + " [포인트] " + point + " [누적금액] " + sum; 
		// person()의 infoString() 출력 - [이름]홍 [전화] 010-999-9999
	}
	
	

}
