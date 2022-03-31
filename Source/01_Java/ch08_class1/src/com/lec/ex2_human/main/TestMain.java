package com.lec.ex2_human.main; // human�̶� ���� �ؿ� main

import com.lec.ex2_human.*; 
// 'import com.lec.ex2_human ��Ű���� ��� Ŭ����(class)�� �����´�.(import)
// import com.lec.ex2_human.Woman;
// import com.lec.ex2_human.Man;
// ctrl + shift + o = �ʿ��� ��Ű���� �ҷ����̴� ����Ű

public class TestMain {

	public static void main(String[] args) {
		
		// ���� ������ Ÿ�Կ����� ������ �񱳴� "==" ���
		int i = 10;
		int j = 10;
//		System.out.println( i==j ? "���׿����� i�� j�� ����" : "�ٸ���");
		if(i==j) {
			System.out.println("i�� j�� ����");
		}
		else {
			System.out.println("�ٸ���");
		} 
		
		// �� ���ܻ��� : ��ü���� String - ���ܷ� "==" ����� �� �ֵ��� ���
		String name = "ȫ�浿"; 
		String name2 = "ȫ�浿";
		if(name == name2) {
			if(name.equals(name2)) {
				System.out.println("name�� name2�� ����");
			}
		} // ���� ���� ������ ���� �ּҸ� ����Ű�� ������ ���ٰ� ���Ѵ�. api���� �� �ڼ��� ��� ����
		
		Woman hee1 = new Woman(); // �����߻� - Ŭ���� import�ؾ���
		Woman hee2 = new Woman();
//		hee1.method();
		// hee1�̶�� �ּҰ�ü�� hee2��� ��ü�� ���� ������ ���̴�!
		if(hee1.equals(hee2)) {
			System.out.println("hee1�� hee2�� ����");
		}
		else {
			System.out.println("hee1�� hee2�� �ٸ���!!");
		} // ���� �ȳ��� ������ �ǳ�, �ٸ��� ���. ������
		// ���� ������ �ʾƵ� equals() ���� Ư���� Ŭ������ ��� �޾Ƽ� ���𵨸� �ؼ� ��� ����.
		// equals()�� java.lang.object���� ��ӹ޾Ƽ� ����ϴ� ��
		// �� ����Ǵ��� ���ظ� �ؾ��Ѵ�.
		
		Man kang = new Man(22, 165, 60.1);
		Man kim = new Man(23, 175, 70.5);
		Man kim1; // ���۷��� ���� ����(= ��ü���� ����) �޸𸮿� �ּ� ���� �غ� �ϴ� ��.
		kim1 = kim; // kim�� �ּҰ� 9�� kim1�� �ּҵ� 9�̴�.
		Man kim2 = new Man(23, 175, 70.5); // �ٸ� �ּҰ��� ����Ǿ� �����Ƿ� kim�� �ٸ� ��ü��!
		if(kim.equals(kim1)) {
			System.out.println("kim�� kim1�� ����.(���� �ּҸ� ����Ų��)");
		}
		if(kim.equals(kim2)) {
			System.out.println("kim�� kim2�� ����(�ּҰ��� ����.)");
		}
		if(!kim.equals(kim2)) {
			System.out.println("kim�� kim2�� �ٸ� �ּҰ��� ������ �ִ�.");
		}
		
		kang.setHeight(160); // �� ����
		kang.setWeight(51); // �� ���� - ���������� �����൵ double���̱� ������ ������ ����ȯ ���� 
		System.out.println("kang��,  Ű: " + kang.getHeight() + ", ������: " + kang.getWeight());
		if(kang.calculateBMI() > 30) {
			System.out.println("�ǰ������ϼ���");
		} else {
			System.out.println("�ǰ��Ͻñ���!");
		}
		
		
	
	}

}
