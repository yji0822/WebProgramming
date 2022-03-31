package com.lec.ex3_math;

import java.util.Random;

public class Ex03_random {

	public static void main(String[] args) {
		
		System.out.println("double ����                      : " + Math.random()); // static method 0~1 ������ ���� ���� ���
		System.out.println("0~45 �̸��� double ���� : " + Math.random()*45); // static method 0~1 ������ ���� ���� ���
		/* 0 <= Math.random() < 1
		 * 0 <= Math.random()*45 < 45
		 * 0~44���� ���� ���� : (int)(Math.random()*45)
		 */
		System.out.println("0~45 �̸��� ���� ����          : " + (int)(Math.random()*45)); // ����ȯ ��ȣ ����! - ��ȣ�� �߸����ָ� ������ 0�� ��µǾ� ������.
		System.out.println("�ζ� ��ȣ �̱�(1~45)     : " + (int)(Math.random()*45)+1 + " ��ȣ �����༭ ����"); // 34������ �������� ��� +1�� ���� ����� ������ �ȴ�. 
		System.out.println("�ζ� ��ȣ �̱�(1~45)     : " + ((int)(Math.random()*45)+1)); // �ݵ�� ��ȣ�� �������!
		
		System.out.println("\n �����Լ�");
		Random random = new Random(); // �����Լ�
		System.out.println("int ����                  : " + random.nextInt()); // -���� +21����� �����߻�
		System.out.println("double ����           : " + random.nextDouble()); // == Math.random() �ݵ�� ��ü�� �����ؼ� �ҷ���� �Ѵ�.
		System.out.println("T/F �� �ϳ��� ����    : " + random.nextBoolean()); // true or false
		System.out.println("0~2 ������ ���� ���� : " + random.nextInt(3)); // 0~3 �̸��� int�� ���� �߻�
		System.out.println("�ζ� ��ȣ �̱�             : " + (random.nextInt(45)+1)); // Math.random()�� �����ϰ� ��ȣ�� �ݵ�� ���־�� �Ѵ�!
		
	}

}
