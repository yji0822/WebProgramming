package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		System.out.println(list.get(0));
		// list�迭�� get�Ҷ� �ε����� access�Ѵ� - access�ϰ��� �ϴ� �ε����� ���� �������� �ʴ´�

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		// string�� �����ϴ� Hashmap , intager�� ���� ����
		// Integer=Key��, String-data
		// Key���� �����ؾ� �Ѵ�!
		hashMap.put(11, "str11"); // 11key���� ���εǴ� ������"str1" �߰��� �� (������ ����)
		hashMap.put(20, "str20"); // 20key���� ���εǴ� ������ "str20" �߰�
		hashMap.put(33, "str33"); 
		
		// ���1.
		System.out.println(hashMap); // {33=str33, 20=str20, 11=str11} - �������� ��µǴ� ���� �� �� �ִ�
		// HashMap�� for�� ����� �Ұ��ϴ�. (������� ���� ���� �ʱ� ����)
		System.out.println(hashMap.get(20)); // key������ ������ get��
		
		System.out.println("remove �� : " + hashMap);
		hashMap.remove(20); // 20key�� ���� remove
		System.out.println("remove �� : " + hashMap);
		
		// ������ ����
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "������ ��� ����" : "������ ����");

		
		System.out.println("\n== while�� �̿��� ��� ==");
		hashMap.put(0, "Hong gildong");
		hashMap.put(10, "Kim donggil");
		hashMap.put(22, "Lee soonsin");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap); // {0=Hong gildong, 22=Lee soonsin, 40=Yu ain, 10=Kim donggil}
		// ������� ����� �Ǵ� ���� �ƴϱ� ������ for���� ����� �� ����. 
		// ��� �ݺ��ڶ�� ���� �����! tokenizer..!�� ���� key���� access -> ketSet Iterator��� �Ѵ�.
		// ��� collection�� iterator�� ���� �� �ִ�.
		Iterator<Integer> iterator = hashMap.keySet().iterator(); // hashMap�� Ű������ iterator�Ѵ�.
		// while�� ��� - ��� ������ ���� �𸣴ϱ�!
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + "�� �����ʹ� " + hashMap.get(key)); // next�� �� ���������� �����´�.
		} // while
		
		
		
	} // main

}
