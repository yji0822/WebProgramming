package singleton1;

public class SingletonClass {

	private int i;
	
	// ��ü ���� ������ �� ��ü �ּҸ� return �ϰ� 
	// ��ü ������ ���� �ʾ����� ��ü �����ϰ� �� �ּҸ� return
	// �ν��Ͻ�(�ּ�)�� null���� �ƴ϶�� ���� ����Ǿ� �ִ� null�� �ҷ����� ��.
	// �̰� �ۼ� �����ν� NEW�� ��ü���� �Ұ�. > MAIN����..!
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
