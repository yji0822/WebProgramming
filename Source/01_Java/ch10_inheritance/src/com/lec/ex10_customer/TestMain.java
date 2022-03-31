package com.lec.ex10_customer;

public class TestMain {

	public static void main(String[] args) {
		
		Customer customer = new Customer("홍", "010-9999-9999", "서울시", "1995-01-01"); // 홍님 감사합니다. 포인트 1000점을 선물로 드립니다.
		customer.buy(100000); // 홍님 구매해주셔서 감사합니다. 적립포인트: 5000, 총 보유하신 포인트: 6000
		customer.buy(900000); // 홍님 구매해주셔서 감사합니다. 적립포인트: 45000, 총 보유하신 포인트: 51000 \n 홍님 VIP고객으로 업그레이드 되셨습니다.
		System.out.println(customer.infoString()); // [이름] 홍 [전화] 010-9999-9999 [주소] 서울시 [포인트] 51000 [누적금액] 1000000
		
		System.out.println();
		Staff staff = new Staff("김", "010-1234-5678", "2022-09-01", "개발팀");
		Person person = new Person("이", "010-7890-1234");
		// Staff도 Person 타입이다. (인간이지만 동물이다)
		
		// person 배열
		Person[] personArr = {customer, staff, person};
		
		System.out.println("일반 for문");
		for(int i=0; i<personArr.length; i++) {
			System.out.println(personArr[i].infoString());
		}
		// 배열0~끝방까지 infoString()
		System.out.println("확장 for문");
		for(Person p : personArr) {
			System.out.println(p.infoString());
		}
		
		// buy(1000) - 확장for문
		for(Person p : personArr) {
			if(p instanceof Customer) { // p 변수가 Customer형 객체(instance)인가?
			((Customer)p).buy(1000); 
			} else {
				System.out.println("buy는 Customer만 가능합니다.");
			} // if-else
		} // for
		

	} // main

} // class
