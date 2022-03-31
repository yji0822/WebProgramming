package com.lec.ex4_object;
// 주민등록번호
// 9512121025252
public class Person {
	
	private long juminNo; // 9512121025252

	// 생성자
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}

	@Override
	public String toString() {
		return "Person [juminNo=" + juminNo + "]";
	}
	
	@Override
	public boolean equals(Object obj) { // 형변환 한 다음 access 
		// p1.equals(p2) 호출할 경우 p1 대신 this, p2대신 obj => 내 객체의 this.juminNo obj.juminNo가 같은지 여부를 return
		// p1.equals(p3) 호출할 경우 p3 대신 obj = > false를 return
		if(obj != null && obj instanceof Person) { // obj가 Person 타입의 객체인지 확인
			return juminNo == ((Person) obj).juminNo; // 강제 형변환
		} else {
			return false;
		} // if-else
	}// equals
	
	
	

}
