package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		S s = new S();
//		A s1 = new S(); - �Ųٷδ� �Ұ�!
//		A a = new A();
		// A���� S���� �� �� ����
		S a = new A(); // �ݵ�� ������ �̷��� �ۼ����־�� �Ѵ�.
		// S�� A�� ���� ��ġ
		S b = new B(); // ������ S Ÿ���̰� B�� ��ü�̴�.
		S c = new C();
		S[] arr = {s, a, b, c}; // Ÿ���� ��ġ ��Ų ��, �迭�� ���� - ������ ����� ���� �۾�
		for(S obj:arr) { // S type�� arr, obj
			System.out.println(obj.s); // SŬ������ int s
		}
		
	}

}
