package com.lec.ex02_store;

public class TestMain {
	
	public static void main(String[] args) {
		// �迭���� ����
		HeadQuaterStore[] store = { new Store1("=== ���а� 1ȣ�� === "),
				                    new Store2("=== ���ð� 2ȣ�� === "),
								    new Store3("=== ���ǰ� 3ȣ�� === ")};
		// HeadQuaterStore[] store = { new HeadQuaterStore("=== ���� === ") 
		// -> ������ ���� �Ұ�.... ������, �Ϲݸ޼ҵ�, getterSetter �־ ��
		
		
		for(HeadQuaterStore st : store) {
			System.out.println(st.getStr());
			st.kimchi();
			st.bude();
			st.bibib();
			st.sunde();
			st.gonggibab();
			System.out.println();
		}
		// �迭�� �ε����� �����Ѵ�.
		
		// �Ϲ� for��
		for(int idx=0; idx<store.length; idx++) {
			System.out.println(store[idx].getStr());
			store[idx].kimchi();
			store[idx].bude();
			store[idx].bibib();
			store[idx].sunde();
			store[idx].gonggibab();
		}
		
		
	}
	
}
