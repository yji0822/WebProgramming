package com.lec.ex05_abc;

public class TestMain {

	public static void main(String[] args) {
		
		S s = new S();
//		A s1 = new S(); - �Ųٷδ� �Ұ�
		S a = new A(); // SŸ�� ���� B�� ��ü
		S b = new B();
		S c = new C();
		
		S[] arr = {a, b, c}; // �տ��� ��ġ��Ų Ÿ���� �迭�� ����
		
		for(S obj : arr) {
			System.out.println(obj.s);
		}
		

	}

}
