package singleton2;

public class SingletonClass {
	private  int i;
	// �Ʒ��� ���ó�� ���� ����!!!
	/*
	private static SingletonClass INSTANCE = new SingletonClass();
	public static SingletonClass getInstance() {
		return INSTANCE;
	}
	*/
	
	private static SingletonClass INSTANCE = null; // ��ü�� �ּҸ� �޾ƿ;� ��
	private SingletonClass() {
		
	} // ��ü ������ �� �ȿ�����! - �����ڰ� private
	public static SingletonClass getInstance() {
		// ��ü �����߾�? �׷��� �ּ� �޾ƿ�
		if(INSTANCE == null) {
			INSTANCE = 	new SingletonClass();
		}
		return INSTANCE;
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

}
