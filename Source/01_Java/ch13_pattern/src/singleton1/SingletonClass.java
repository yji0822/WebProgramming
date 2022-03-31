package singleton1;

public class SingletonClass {

	private int i;
	
	// 객체 생성 했으면 그 객체 주소를 return 하고 
	// 객체 생성을 하지 않았으면 객체 생성하고 그 주소를 return
	// 인스턴스(주소)가 null값이 아니라면 원래 저장되어 있는 null값 불러오는 것.
	// 이걸 작성 함으로써 NEW로 객체생성 불가. > MAIN으로..!
	private static SingletonClass INSTANCE = new SingletonClass();
	public static SingletonClass getInstance() {
		return INSTANCE;
	}
	
	// getter&setter
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	

}
