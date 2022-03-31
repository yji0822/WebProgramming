package com.lec.ex1_string;

public class Ex02_stringAPImethod {

	public static void main(String[] args) {
		
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "    ja    va     ";
		
		System.out.println("1. " + str1.concat(str2)); 
		// 1. abcXabcABCXabc - String �ΰ��� ���ϴ� �޼ҵ� (��Ĺ�Ѵ�)
		System.out.println("2. " + str1.substring(3)); // 2. Xabc - 3��° �ε������� ������ ���
		System.out.println("3. " + str1.substring(3, 5)); // 3. Xa - 3��°���� 5��° �ձ���
		
		System.out.println("4. " + str1.length()); // 4. 7 - ���ڱ���
		
		System.out.println("5. " + str1.toUpperCase()); // 5. ABCXABC - �빮�ڷ�
		System.out.println("6. " + str1.toLowerCase()); // 6. abcxabc - �ҹ���
		System.out.println("7. " + str1.charAt(3)); // 7. X - 3��° ���� ��ȯ
		
		System.out.println("8. " + str1.indexOf('b')); 
		// 8. 1 - ù��° b���ڰ� ������ �ε��� ��ġ(���� ���� 0)
		System.out.println("9. " + str1.indexOf('b', 3)); 
		// 9. 5 - 3��°���� �˻��ؼ� ������ ù��° 'b'�� �ε��� ��ġ
		System.out.println("10. " + str1.indexOf("abc"));
		// 10. 0 - ù��° abc�� ������ ��ġ
		System.out.println("11. " + str1.indexOf("abc",3));
		// 11. 4 - 3��°���� �˻��ؼ� ������ "abc"��ġ
		// 12. -1 - ã�� ���ڰ� ������ -1�� ��ȯ�Ѵ�.
		System.out.println("12. " + str1.indexOf('z'));
		System.out.println("13. " + str1.lastIndexOf('b'));
		// 13. 5 - ������ b�� ��ġ ��ȭ��ȣ �� �� ���� ���
		System.out.println("14. " + str1.lastIndexOf('b', 3));
		// 14. 1 - 3��°���� �� ������ b
		
		str1 = "abcXabc";
		str2 = new String("ABCXabc");
		str3 = "    ja    va     ";
		
		System.out.println("15. " + str1.equals(str2));
		// 15. false str1�� str2�� ���� ���ڿ����� Ȯ��
		System.out.println("16. " + str1.equalsIgnoreCase(str2)); // 16. true - ��ҹ��ڱ��о��� ��  **
		System.out.println("17. " + str3.trim()); // 17. ja    va - �� �� �������� (�߰� ���������ϴ°� �ȵ�)
		System.out.println("18. " + str1.replace('a', '9')); // 18. 9bcX9bc - ��� 'a'�� '9'�� �����Ѵ�
		System.out.println("19. " + str1.replace("abc", "#")); //19. #X# - �������ڸ� �Ѳ����� ���浵 ����
		System.out.println("20. " + str3.replace(" " , "")); // 20, java - ���� ��� ����!
		System.out.println("21-1. " + str1.replaceAll("abc", "Z")); // "abc"�� "Z"��
		System.out.println("21-2. " + str1.replace("abc", "Z")); // "abc"�� "Z"��
		
		// ���� ǥ����
		String str = "�ȳ�Hello"; //�ѱ��̳� ���� �� �� �ϳ��� ��� ����� ������
		// �����ڸ� ��� *�� �ٲٰų�...
		System.out.println(str.replaceAll("[a-zA-Z]", "")); 
		// ���ĺ��� ""�� �����ϴ�.. ���ĺ� �ҹ��ڿ� �빮��... ���۰� ���� ������ ��.
		System.out.println(str.replaceAll("[��-�R]", ""));
		// �ѱ��� ������ ���� �������� �R��.
		// ���ڿ� �޼ҵ�� ���ڿ��� �������� ����.
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
		// ��µ� ���� ���� ó�� �־�ξ��� ���ڿ����� �ٲ� ���� �ƴϴ�. �׳� �����ؼ� ����� ��.
	} 
}
