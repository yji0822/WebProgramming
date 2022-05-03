package com.lec.ex1_list;

import java.util.Vector;

public class Ex03_Vector {

	public static void main(String[] args) {
		
		Vector<Object> vec = new Vector<Object>(); // Object를 적어주면 모든 타입의 객체들이 들어올 수 있다.
		vec.add(10); // vec.add(new Integer(10)); 과 동일
		vec.add(new AClass());
		/* BClass objB = new BClass();
		vec.add(objB); => Object로 해놓았기 때문에 위의 형식처럼 출력해도 무방하다. */
		vec.add(new BClass());
		
		System.out.println(vec); // 주소형태로 출력 - 0번째 인덱스 toString(), 1번째 인덱스 toString()..
		for(Object obj : vec) {
			System.out.println(obj);
		} // 마찬가지로 주소 출력 => 불러오는 클래스 안에서 toString을 override 해주어야 한다.
		for(int idx=0; idx<vec.size(); idx++) {
			System.out.println(vec.get(idx));
		}

		
	} // main

} 
