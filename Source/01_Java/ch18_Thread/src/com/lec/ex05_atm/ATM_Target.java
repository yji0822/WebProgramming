package com.lec.ex05_atm;
// ATM card = new ATM(20000);
// ATM_Target target = new ATM_Target(card);
public class ATM_Target implements Runnable {

	private boolean flag; 
	private ATM card;
	
	public ATM_Target(ATM card) {
		this.card = card;
	}
	
	// �Ա��� �����ϸ� �Ա� ������� ���� �Ұ�
	@Override
	public void run() {
		// �����ߴٰ� ����ߴٰ� - 5ȸ ���� ����
		for(int i=0; i<10; i++) { // �÷��� �۾�
			if(flag) { // ���
				card.withdraw(1000, Thread.currentThread().getName()); // �������̸��� a�̸� 1000�� ����ϰ� flag false�� ��ȯ 
				flag = false;
			} else { // ����
				card.deposit(1000, Thread.currentThread().getName());
				flag = true;
			} // if
		} // for
	} // run

}
