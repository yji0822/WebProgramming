package com.lec.method;
// Arithmetic.sum/evenOdd (static) vs abs(�Ϲ�)
public class Ex03 {
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10); // ��
		System.out.println("1~10������ ���� " + tot);
		System.out.println(Arithmetic.evenOdd(10)); // ���� Ȧ¦ �Ǻ�
		
		// == Scanner sc = new Scanner();
		Arithmetic ar = new Arithmetic(); 
		// ���ο� �޸𸮿� ���ο� Ÿ���� �Ҵ��ؼ� �޸� ���� �ø� ��, ����� ����� �� �ְ� �ϵ���
		System.out.println(ar.abs(-8)); // static �ƴ� �Ϲ� �޼ҵ�� ���� �߻�
		
	}

}
