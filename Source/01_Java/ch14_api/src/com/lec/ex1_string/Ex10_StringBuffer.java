package com.lec.ex1_string;

public class Ex10_StringBuffer {

	public static void main(String[] args) {
		
		String str = "abc";
		System.out.println(str.hashCode());
		str = str + "d";
		System.out.println(str.hashCode());
		
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("strBuilder = " +strBuilder);
		System.out.println(strBuilder.hashCode());
		
		// 2. ������ ���ڿ��� �߰�
		strBuilder.append("def"); // ������ "abc"�� "def"�� �߰� : abcdef
		System.out.println("strBuilder(���ڿ��߰�) = " +strBuilder);
		System.out.println(strBuilder.hashCode());
		
		// 3. ������ ���ڿ� ���̿� �߰�
		strBuilder.insert(3, "AAA"); // 3��°�� "AAA" �߰� (�ε���ó�� 0���� �����Ѵ�.) abcAAAdef
		System.out.println("strBuilder(���ڿ����̿� �߰�) = " + strBuilder);
		System.out.println(strBuilder.hashCode());
		
		// 4. ����
		strBuilder.delete(3, 5); // 3��°���� 5��° �ձ��� ���� : abcAdef
		System.out.println("strBuilder(���ڿ� ����) = " + strBuilder);
		System.out.println(strBuilder.hashCode());
		
		// 5. �ε��� �ѱ��� ����
		strBuilder.deleteCharAt(3);
		System.out.println("strBuilder(���° �ε��� ����) = " + strBuilder);
		System.out.println(strBuilder.hashCode());
	
		
		
	}

}
