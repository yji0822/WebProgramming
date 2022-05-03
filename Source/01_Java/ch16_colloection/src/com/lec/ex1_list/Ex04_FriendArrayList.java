package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;

import com.lec.ex2_map.Friend;

public class Ex04_FriendArrayList {

	public static void main(String[] args) {
		
		// ������ �迭 ���
		Friend[] friends = new Friend[5];
		friends[0] = new Friend("ȫ", "010-9999-9999");
		friends[1] = new Friend("ȫ", "010-8888-8888");
		for(int i=0; i<friends.length; i++) {
			System.out.println(friends[i]);
		}
		
		/** ArrayList : index�� �ְ�, �ߺ� ��� **/
		System.out.println("\nArrayList");
		ArrayList<Friend> fs = new ArrayList<Friend>(); 
		// index�� �������� ���δ�
		fs.add(new Friend("ȫ1", "010-9999-9999")); // 0���ε���
//		fs.add(2, new Friend("��浿", "010-8888-8888")); // 2�� �ε����� ���µ� add�� ���ָ� ���� �߻�
		fs.add(new Friend("��1", "010-8888-8888")); // 1�� �ε���
		Friend temp = new Friend("��1", "010-7777-7777", new Date(95,11,12));
		fs.add(temp); // 2�� �ε���
		for(int i=0; i<fs.size(); i++) {
			System.out.println(fs.get(i));
		}
		

	} // main()

}
