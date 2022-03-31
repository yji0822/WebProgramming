package home.quiz1_company;

public abstract class Employee {
	
	private String name; // �̸�
	
	// ������
	public Employee() {}
	public Employee(String name) {
		this.name = name;
	}
	
	// �޼ҵ�
	public abstract int computePay(); 
	public final int computeIncentive() {
		int pay = computePay();
		// �Լ��� �޾ƿ��� ����� �Ϸ� ��ǻ�Ͱ� �Ź� �Դٰ��� �ϸ鼭 �޾ƾ� �ϱ� ������ ������ �־��ָ� ����.
		if(pay >= 2000000) {
			return (int)(pay*0.1); // 200������ ������ �μ� 10�� �ִ� ��
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
