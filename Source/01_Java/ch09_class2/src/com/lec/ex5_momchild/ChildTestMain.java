package com.lec.ex5_momchild;

public class ChildTestMain {

	public static void main(String[] args) {
		
		Child child1 = new Child("첫째 똘만이");
		Child child2 = new Child("둘째 갑돌이");
		Child child3 = new Child("셋째 똘순이");
		
		child1.takeMoney(1000);
		child2.takeMoney(1000);
		child3.takeMoney(1000);
		// 돈이 변수마다 계속 초기화가 되는 현상 발생 - 전혀 다른 엄마의 지갑에서 돈이 빠져나가게 된다. MomPouch가 일반 변수라서 그렇다.
		// 해결방법 : 엄마를 하나로 만들어 주어야 한다! - 엄마를 static 으로 만들어 주어야 한다.
		
		System.out.println(Child.momPouch.money); // 클래스 이름을 통해서 액세스 하는 것이 일반적.
		System.out.println(child1.momPouch.money); 
		System.out.println(child2.momPouch.money); 
		System.out.println(child3.momPouch.money); 
		
	}

}

// static - 공유. final 확인을 위해서 사용 많이 한다.