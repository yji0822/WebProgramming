package com.lec.ex;
// �������� *** : &&(AND)  ||(OR)   
// �����̰� �̻ڰ�&&���ϴ� / �̻ڰų�||���ϴ� 
public class Ex04 {

	public static void main(String[] args) {
		int i = 1;
		int j = 10;
		int h = 10;
		
		// AND
		boolean result = ( (i>j) && (++j>h) ); // F && T 
		// **** ���� ������ F�̱� ������ ���� ���� �ڿ� ������ �н��ȴ�. ****
		// && ������ ������ false�� ���, ������ �������� ����.
		System.out.println("result=" +result+ "\t j=" +j); // false �����ȵ� j�� 10
		result = ( (i<j) && (++j>h) ); // T && T 
		System.out.println("result=" +result+ "\t j=" +j); // true ������ j�� 11
		
		// OR
		// || ������ ������ true�� ���� ���� ���� ����.
		result = ( (i<j) || (++j>h) ); // ������ ����� T�� ���� ���� �ڵ� �н�
		// �����ڿ켱������ ��ȣ�� �����ص� ������ ���� �������� �������� ���� ���������!
		System.out.println("result=" +result+ "\t j=" +j); // true ���� ������ �� 11
		
		
	}

}
