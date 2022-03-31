package home.quiz1_company;

public abstract class Employee {
	
	private String name; // 이름
	
	// 생성자
	public Employee() {}
	public Employee(String name) {
		this.name = name;
	}
	
	// 메소드
	public abstract int computePay(); 
	public final int computeIncentive() {
		int pay = computePay();
		// 함수를 받아오면 계산을 하러 컴퓨터가 매번 왔다갔다 하면서 받아야 하기 때문에 변수에 넣어주면 좋다.
		if(pay >= 2000000) {
			return (int)(pay*0.1); // 200만원이 넘으면 인센 10퍼 주는 것
			}
		return 0;
		}
	
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
