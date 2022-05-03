package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	
	public static void main(String[] args) {
		
		String[] arr = new String[5]; // String���� �Ϲ� �迭
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("str0");
		hashSet.add("str1"); // �ε��� ���� ����.
		System.out.println(hashSet); // [str1, str0]
		
		hashSet.add("str1"); // �ߺ��� ���� �� �־��ָ� ���� �ʴ´�.
		System.out.println(hashSet); // [str1, str0]
		// �ε����� Ű���� ��� �������� �ʴ´�. - Iterator �ʿ�.
		// ��������� ������ ���ؼ� Iterator ���ش�. - ������ �����͸����� Iterator ����
		Iterator<String> iterator = hashSet.iterator();
		while(iterator.hasNext()) { // next�Ұ� �ִ��� ������ Ȯ��
			System.out.println(iterator.next()); // next�Ѱ� ������ ���� next�� ���ش�. 
		} 
		// ����Ʈ�� ���� ����Ų�ٸ� while���� ����ǰ� while���� �ι� ������� �ʴ´�. 
		// �����ϱ� ���ؼ��� Iterator�� �ι� ���� �������־�� ��
		
	} // main()

}
