package com.lec.ex02_protectedmember;

public class Child extends SuperIJ { 
	// private까지 상속! private는 상속을 받았으나 바로 사용할 수 없다. getter&setter로 access해준다.
	
	private int total;

	public Child() {
		System.out.println("매개변수 없는 Child 생성자 함수");
	}
	// Child c = new Child(10, 20);
	public Child(int i, int j) {
		// private까지 상속! Child 클래스에서도 사용할 수 있다.
//		this.i = i; - 불가. private로 해놓았기 때문에 다른 파일에서는 이용 불가
		// 해결방법 - setter 불러오기(public이나 protected 이기 때문에 사용 가능)
		setI(i);
		setJ(j);
		System.out.println("매개변수 있는 Child 생성자");
	}
	
	// 메소드
	public void sum() { // void 리턴이 없다. 
//		total  = i + j; 불가
		total = getI() + getJ();
		System.out.printf("본 객체의 i = %d, j = %d. \n", getI(), getJ());
		System.out.printf("본 객체의 total = %d", total);
			}
	// return 밑에 무언가를 작성하면 당연히 에러 발생. return을 한 순간 호출한 곳으로 가기 때문에 밑에 문장 실행 불가
	
	

}
