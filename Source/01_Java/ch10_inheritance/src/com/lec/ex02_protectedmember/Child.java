package com.lec.ex02_protectedmember;

public class Child extends SuperIJ { 
	// private���� ���! private�� ����� �޾����� �ٷ� ����� �� ����. getter&setter�� access���ش�.
	
	private int total;

	public Child() {
		System.out.println("�Ű����� ���� Child ������ �Լ�");
	}
	// Child c = new Child(10, 20);
	public Child(int i, int j) {
		// private���� ���! Child Ŭ���������� ����� �� �ִ�.
//		this.i = i; - �Ұ�. private�� �س��ұ� ������ �ٸ� ���Ͽ����� �̿� �Ұ�
		// �ذ��� - setter �ҷ�����(public�̳� protected �̱� ������ ��� ����)
		setI(i);
		setJ(j);
		System.out.println("�Ű����� �ִ� Child ������");
	}
	
	// �޼ҵ�
	public void sum() { // void ������ ����. 
//		total  = i + j; �Ұ�
		total = getI() + getJ();
		System.out.printf("�� ��ü�� i = %d, j = %d. \n", getI(), getJ());
		System.out.printf("�� ��ü�� total = %d", total);
			}
	// return �ؿ� ���𰡸� �ۼ��ϸ� �翬�� ���� �߻�. return�� �� ���� ȣ���� ������ ���� ������ �ؿ� ���� ���� �Ұ�
	
	

}
