package com.lec.ex1_list;

import java.util.Vector;

public class Ex03_Vector {

	public static void main(String[] args) {
		
		Vector<Object> vec = new Vector<Object>(); // Object�� �����ָ� ��� Ÿ���� ��ü���� ���� �� �ִ�.
		vec.add(10); // vec.add(new Integer(10)); �� ����
		vec.add(new AClass());
		/* BClass objB = new BClass();
		vec.add(objB); => Object�� �س��ұ� ������ ���� ����ó�� ����ص� �����ϴ�. */
		vec.add(new BClass());
		
		System.out.println(vec); // �ּ����·� ��� - 0��° �ε��� toString(), 1��° �ε��� toString()..
		for(Object obj : vec) {
			System.out.println(obj);
		} // ���������� �ּ� ��� => �ҷ����� Ŭ���� �ȿ��� toString�� override ���־�� �Ѵ�.
		for(int idx=0; idx<vec.size(); idx++) {
			System.out.println(vec.get(idx));
		}

		
	} // main

} 
