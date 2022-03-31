package com.lec.ex1_string;

public class Ex05_regex {
	public static void main(String[] args) {
		String str = "010-9999-9999 yisy0703@naver.com (02)565-8888 �ݰ����ϴ�. Hello 951212-2521251  010-7777-8888  abc@hong.co.kr";
//		System.out.println("replace => " + str.replace("0", "ȫ")); // Ư�����ڿ��� ���� ���� - 0�� ȫ����
//		System.out.println(str.replace("010-8888-8888", newChar)); - �Ұ�
		// ����ǥ���� 
		// Ư���� ��Ģ�� ���� �ִ�..!
		/* ����ǥ����(regex)
		 * 1. ���� : https://goo.gl/HLntbd
		 * 2. ���� ���� 
		 * 		\d - (���ڿ� ��ġ, [0-9] �� ����) \D - ���ڰ� �ƴ� ��
		 * 		\s - (whitespacen : space, ��, ����)
		 * 		\w - (�����ڳ� ����, [a-zA-Z0-9]�� ����) \W - �����ڳ� ���ڰ� �ƴѹ���
		 * 		. - (�����ϳ�)
		 * 		+ - 1�� �̻� �ݺ�
		 * 		* - 0�� �̻� �ݺ�
		 * 		? - 0~1�� �ݺ�
		 * 		{2,3} {2,4} - 2~3ȸ �ݺ�, 2~4ȸ �ݺ�
		 * 3. ����ǥ���� ������ - ���۸�
		 * https://www.regexpal.com/
		 * regexr.com
		 * ex) ��ȭ��ȣ : [(]?[0-9]{2,3}\D[0-9]{3,4}-[0-9]{4}
		 * 	       �̸��� : \w+@\w+(.\w+){1,2}
		 * 4. Ư�� ����ǥ������ ���ڿ� ���� : (��ȭ��ȣ�� �� �� �����ϰ� ���� ���) replaceAll("����ǥ����", "��ü���ڿ�") ���� �ٲٰ� ���� ���ڿ�(��ü����)
		 */
		
//		System.out.println(str.replaceAll("[0-9]", "X"));
//		System.out.println(str.replaceAll("\\d", "X")); // \n \tó�� Ư���� ����� �ִ��� �˰� �ν��ؼ� ������ �߱� ������ \�� ���ڷ� ���� ������ �ѹ� �� �����ش�
//		System.out.println(str.replaceAll("\\D", "** ��ȭ��ȣ ���� **"));
		// * ��ȭ��ȣ ����
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}", "**��ȭ��ȣ ���� **"));
		System.out.println();
		// �̸��� ����
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "==�̸��ϻ���=="));
		System.out.println();
		// ���ĺ� ��� *�� ��ü
		System.out.println("���ĺ� ��� *�� ��ü : " + str.replaceAll("[a-zA-Z]", "*"));
		// �ѱ� �� �� ���ֱ�
		System.out.println("�ѱۻ��� : " + str.replaceAll("[��-�R��-��]", "#"));
		// �ֹι�ȣ ���ڸ��� *�� ��ü
		System.out.println("�ֹι�ȣ ���ڸ� ���� : " + str.replaceAll("[0-9]{7}", "*******")); // 7���ݺ��Ѵ�. - �ֹι�ȣ
		
		
	}
}
