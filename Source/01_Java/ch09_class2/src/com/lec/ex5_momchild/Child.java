package com.lec.ex5_momchild;
// Child first = new Child("첫째");
// first.takeMoney(1000); // 엄마 천원만
public class Child {
	
	private String name; // 객체데이터
	static MomPouch momPouch; // static - 
//	제품명은 같지만 product serial no. 는 다르니 확인하고 싶을 때. 
//	MomPouch momPouch; // 디폴트. 객체데이터
//	MomPouch momPouch = new MomPouch(); 와 같다
	// 생성자
	public Child() {}
	public Child(String name) {
		this.name = name;
		momPouch = new MomPouch();
	}
	// 메소드
	public void takeMoney(int money) { // int money - 자식이 달라는 돈
		if(momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name + "가 " + money + "원 가져가서 엄마 지갑에는 "
					+ momPouch.money + "원이 남아있다.");
		} else {
			System.out.println(name + "가 돈을 못 받음. 현재 엄마 지갑에는 " 
					+ momPouch.money + "원 남아있다.");
		} // if-else
	} // takeMoney
		
} // Child class