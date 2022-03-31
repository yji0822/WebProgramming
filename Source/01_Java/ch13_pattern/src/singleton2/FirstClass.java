package singleton2;

public class FirstClass {
	
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("싱글톤 객체의 i값 : "+singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("싱글톤 객체의 i값 수정 후 : " + singletonObject.getI());
	}
}

// 생성자 실행. 999변경 후 실행. 종료
// INSTANCE변수 999 가지고 있는 상태로 메인 메모리에 남아있다.