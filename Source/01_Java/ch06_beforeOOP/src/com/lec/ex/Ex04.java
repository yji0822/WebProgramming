package com.lec.ex;
// �ٸ� ��Ű���� �Լ��� �ҷ��ͼ� ���� ���� ��! - import�� ����
// Arithmetic();
import com.lec.method.Arithmetic;

public class Ex04 {
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);	
		System.out.println(tot);
		Arithmetic ar = new Arithmetic();
		// Ŭ���� ���ο� Ÿ���� ����� �� / ar = ��ü, ��ü����, �ν��Ͻ� (Ŭ������ �޸𸮿� �÷�����)
		System.out.println("-8800�� ���밪�� " + ar.abs(-8800));
	}

}
