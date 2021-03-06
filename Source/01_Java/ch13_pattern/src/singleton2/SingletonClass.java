package singleton2;

public class SingletonClass {
	private  int i;
	// 아래의 방식처럼 많이 쓴다!!!
	/*
	private static SingletonClass INSTANCE = new SingletonClass();
	public static SingletonClass getInstance() {
		return INSTANCE;
	}
	*/
	
	private static SingletonClass INSTANCE = null; // 객체의 주소를 받아와야 함
	private SingletonClass() {
		
	} // 객체 생성은 이 안에서만! - 생성자가 private이기 때문
	public static SingletonClass getInstance() {
		// 객체 생성했어? 그러면 주소 받아와
		if(INSTANCE == null) {
			INSTANCE = 	new SingletonClass(); // 있으면 그 객체 주소를 불러오는 것
		}
		return INSTANCE; // 없으면 객체 주소 리턴
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

}
