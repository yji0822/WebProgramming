package singleton2;

public class TestMain {

	public static void main(String[] args) {
		
		FirstClass firstObj = new FirstClass();
		// �̱��� ��ü�� i�� : 0
		// �̱��� ��ü�� i�� ���� �� : 999
		SecondClass secondObj = new SecondClass();
		//SecondClass ������ ���� ��
//		�̱��� ��ü�� i�� : 999
//		SecondClass ������ ��
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("Main�Լ����� �̱��� ��ü�� i�� : " + singObj.getI());
		// Main�Լ����� �̱��� ��ü�� i�� : 999

	}

}
