package com.lec.ex1_student;

public class StudentTestMain1 {

	public static void main(String[] args) {		
		// �̸� ���� ���� ����
		Student1[] student = {new Student1("���켺", 90, 90, 90),
							  new Student1("���ϴ�", 90, 90, 91),
							  new Student1("Ȳ����", 80, 80, 80),
							  new Student1("������", 80, 80, 81),
							  new Student1("������", 70, 70, 70)};
		int[] tot = new int[5]; // tot[0] �����, tot[1] �����... tot[4] ��մ���
		double[] avg = new double[5]; // ������� avg[0]������� avg[1]�������...avg[4]����� ���
		// �迭�� �ʱⰪ�� ��� 0�̴�!
		
		System.out.println("�������������������������������������������������������������������");
		System.out.println("\t\t\t��\t��\tǥ ");
		System.out.println("------------------------------------------------------------------");
		System.out.println("                  �̸�           ����           ����            ����             ����             ���");
		System.out.println("------------------------------------------------------------------");
		for(Student1 s : student) {
			s.Disp(); // ����� ����
			tot[0] += s.getKor(); // ���� ����
			tot[1] += s.getEng();
			tot[2] += s.getMath();
			tot[3] += s.getTot();
			tot[4] += s.getAvg(); // �ڵ����� ����ȯ
		}
		for(int idx=0 ; idx<avg.length; idx++) { // ����� ��� ��� avg[0] = tot[0]/5
												 // avg[1] = tot[1]/5
												 // avg[4] = tot[4]/5 
			avg[idx] = (double)tot[idx]/student.length; // �Ҽ����� �ȵ��� ����ȯ!
		}
		System.out.println("------------------------------------------------------------------");
		System.out.print("\t����\t");
		for(int t : tot) {
			System.out.print(t + "\t");
		} // ���� ���
		System.out.print("\n\t���\t");
		for(double a : avg) {
			System.out.print(a + "\t");
		} // ��� ���
		System.out.println("\n�������������������������������������������������������������������");
		
		
	}

}
