package com.lec.condition;

public class Ex01_if {

	public static void main(String[] args) {
		int seoulLunchPrice = 5000; // �޸� 4����Ʈ�� ���ﷱġ�����̽� ������ 5000���� ��!
		
		if(seoulLunchPrice >= 8000) {
			System.out.println("���� ���ɰ� ��ο� ��");
			// tip) seoul�� ġ�� ctrl+space ġ�� �ڵ��ϼ�
		} // ���� �ƴϸ� ���� X
		// �ٸ� ������ �߰��ϰ� ���� ���� else if
		else if (seoulLunchPrice >= 6000) {
			System.out.println("�׷�... �������� ��...");
		}
		else if (seoulLunchPrice >= 5000) {
			System.out.println("��ȫ �̷� ���� �ִٱ�??@??@?");
		}
		// ���� �ƴϾ �����ϰ� ������ else ���� �ۼ�����!
		else {
			System.out.println("�� �δ�!");
		}
		
		//tip_ ctrl+shift+f - ������ �ְ� �������ִ�!
		

	}
	

}
