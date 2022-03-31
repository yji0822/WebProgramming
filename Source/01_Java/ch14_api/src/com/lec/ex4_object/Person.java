package com.lec.ex4_object;
// �ֹε�Ϲ�ȣ
// 9512121025252
public class Person {
	
	private long juminNo; // 9512121025252

	// ������
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}

	@Override
	public String toString() {
		return "Person [juminNo=" + juminNo + "]";
	}
	
	@Override
	public boolean equals(Object obj) { // ����ȯ �� ���� access 
		// p1.equals(p2) ȣ���� ��� p1 ��� this, p2��� obj => �� ��ü�� this.juminNo obj.juminNo�� ������ ���θ� return
		// p1.equals(p3) ȣ���� ��� p3 ��� obj = > false�� return
		if(obj != null && obj instanceof Person) { // obj�� Person Ÿ���� ��ü���� Ȯ��
			return juminNo == ((Person) obj).juminNo; // ���� ����ȯ
		} else {
			return false;
		} // if-else
	}// equals
	
	
	

}
