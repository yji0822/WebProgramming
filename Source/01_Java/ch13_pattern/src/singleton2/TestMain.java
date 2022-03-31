package singleton2;

public class TestMain {

	public static void main(String[] args) {
		
		FirstClass firstObj = new FirstClass();
		// 싱글톤 객체의 i값 : 0
		// 싱글톤 객체의 i값 수정 후 : 999
		SecondClass secondObj = new SecondClass();
		//SecondClass 생성자 실행 중
//		싱글톤 객체의 i값 : 999
//		SecondClass 생성자 끝
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("Main함수에서 싱글톤 객체의 i값 : " + singObj.getI());
		// Main함수에서 싱글톤 객체의 i값 : 999

	}

}
