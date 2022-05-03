package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex02_LinkedList {

	public static void main(String[] args) {
		// ArrayList
		ArrayList<String> arrayList = new ArrayList<String>();
		// LinkedList 
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("Str0"); // 0�� �ε���
		linkedList.add("Str1"); // 1�� �ε���
		linkedList.add("Str2"); // 2�� �ε���
		linkedList.add("Str3"); // 3�� �ε���
		linkedList.add(1, "Str1234"); // 1���ε���
		
		// ���
		System.out.
		println(linkedList);
		for(String list : linkedList) {
			System.out.println(list);
		} 
		
		// ������ �ʱ�ȭ
		linkedList.clear(); // remove
		System.out.println(linkedList.isEmpty() ? "�����Ͱ� �����ϴ�." : "�����Ͱ� �ֽ��ϴ�.");
		
	}

}
