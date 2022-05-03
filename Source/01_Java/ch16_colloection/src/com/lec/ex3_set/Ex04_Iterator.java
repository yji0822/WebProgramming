package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Ex04_Iterator {

	public static void main(String[] args) {
		
		// List
		ArrayList<String> list = new ArrayList<String>();
		list.add("STR");
		list.add("STR");
		System.out.println(list);
		
		// ��� - ������ Iterator�� ���Ѵ�.
		System.out.println("*Iterator ���");
		Iterator<String> iterator1 = list.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		} // ���̻� next �Ұ� ������ ������ ��ġ�� �����鼭 ��� ����
		
		// Ȯ�� for������ �ݵ�� ������� ����� �� �ֵ��� �Ѵ�.
		System.out.println( "*Ȯ��for�� ���");
		for(String l : list) {
			System.out.println(l);
		}
		
		
		// Map
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ȫ�浿", "010-0000-0000");
		map.put("��浿", "010-1234-5678"); // �����ʹ� ���Ƶ� ������ Ű���� ������ �ȵ�
		
		Iterator<String> iterator2 = map.keySet().iterator(); // Ű������ ���ͷ����� ���
		while(iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.println(key + " key�� ������ : " + map.get(key));
		}
		
		
		// Set
		HashSet<String> set = new HashSet<String>();
		set.add("str0");
		set.add("str1");
		set.add("str1"); // �ߺ� ��� �Ұ�
		
		Iterator<String> iterator3 = set.iterator();
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next());
		}
		
		

	}

}
