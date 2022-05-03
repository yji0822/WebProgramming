package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		
		// ������ �迭 - ���� ũ�⸦ ���س��� ���ϴ� �濡�� ������ ���� ����
		System.out.println("1. ���� �迭");
		String[] array = new String[5];
		array[0] = "str0";
		array[1] = "str1";
		array[4] = "str4"; // 2��,3���� �н��ص� �ȴ�.
		for(int i = 0; i<array.length; i++) {
			System.out.printf("arr[%d]=%s \t", i, array[i]);
		}
		System.out.println(); // ����
		for(String arr : array) { // Ȯ��for��
			System.out.print(arr + "\t");
		}
		
		// ArrayList
		System.out.println("\n\n2. ArrayList ");
		ArrayList<String> arrayList = new ArrayList<String>(); // String ���� ArrayList - ��������X
//		ArrayList<int> list = new ArrayList<int>(); // ���ʵ�����Ÿ���� ����� �� ���� (objectŸ�Ը� ����)
		ArrayList<Integer> list = new ArrayList<Integer>(); // wrapper class �̿��ؼ� ������ش�.
		arrayList.add("str0"); // 0�� �ε��� ���� - str0�̶� ��ü ���� �Ϸ�
		arrayList.add("str1"); // 1�� �ε��� ����
		arrayList.add("str2"); // 2�� �ε��� ����
		System.out.println(arrayList); // add �Ѱ͸�ŭ index�� ���δ�. [str0, str1, str2]
		arrayList.add(1, "str11111111111"); // 1�� �ε��� - ���� 1�� �ε����� 2�� �ε�����, ���� 2�� �ε����� 3������ �з�����.
		
		// ���1.
		System.out.println(arrayList);
		// �� ����
		arrayList.set(1, "11111"); // 1�� �ε��� �� ����
		System.out.println(arrayList);
		// �⺻������ toString�� �������̵� �Ǿ��� �ִ� ArrayList
		// Ȯ�� for���� �̿��Ͽ� ���ϴ� ���·� ����� �ϵ��� �������ش�. �迭�� ������ ��� - ���2.
		for(String alist : arrayList) {
			System.out.print(alist + "\t");
		} 
		
		System.out.println("\n\n3. remove�� ��...(1�� �ε��� ����)"); // Ư�� �ε����� ����ٴ� ��
		arrayList.remove(1); // 1��° �ε����� ������ ���� (2->1���ε���, 3->2���ε���)
		// �߰� �ε����� �����ϸ� �ڵ����� �鿩���Ⱑ �Ǿ �����ؼ��� ������� �ʴ´�.
		arrayList.remove(arrayList.size()-1); // �� ������ �ε��� ������ ���� (array.length == arrayList.size())
		for(int idx=0; idx<arrayList.size(); idx++) {
			System.out.printf("%d��° �ε��� ���� %s\t\t", idx, arrayList.get(idx));
		} // arrayList ��� ����! arrayList.get() == array[idx]
		
		System.out.println(); // ����
		System.out.println("\n4. arrayList ������ ����");
		arrayList.clear(); // arrayList�� ��� ������ ���� - �����͸� ���� arrayList�� size�� 0�� �ȴ�.
		// �����Ͱ� �����Ǿ����� Ȯ���ϴ� �޼ҵ�
		if(arrayList.size() == 0) { 
			System.out.println("arrayList�� �����ʹ� �����ϴ�. arrayList.size()");
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�. arrayList.isEmpty()");
		}
		System.out.println(arrayList);
		
		arrayList = null; // arrayList ��ü ���� (��ü�� ����)
//		System.out.println(arrayList.size()); - ����. ����ó�� �߻�
		
	}

}
