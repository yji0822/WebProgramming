package com.lec.ex8_student;

public class StudentTestMain {

	public static void main(String[] args) {
		
		Student[] student = {new Student("���켺", 90, 91, 91),
							 new Student("���ϴ�", 100, 80, 95),
							 new Student("Ȳ����", 95, 80, 90),
							 new Student("������", 80, 80, 81),
							 new Student("������", 70, 70, 70)};
		
		int[] tot = new int[5]; // ���մ���
		double[] avg = new double[5]; // ��� ����

		System.out.println("�������������������������������������������������������������������");
		System.out.println("\t\t\t��\t��\tǥ ");
		System.out.println("------------------------------------------------------------------");
		System.out.println("  ��ȣ\t �̸�\t ����\t ����\t ����\t ����\t ���");
		System.out.println("------------------------------------------------------------------");
		for(Student s : student) {
			s.disp(); // �Է��� ������ ��� �� ����
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMath();
			tot[3] += s.getTot();
			tot[4] += s.getAvg(); // �ڵ����� ����ȯ
		}
		for(int idx=0 ; idx<avg.length; idx++) { 
			avg[idx] = (double)tot[idx]/student.length; 
		}
		System.out.println("------------------------------------------------------------------");
		System.out.print("\t ����\t ");
		for(int t : tot) {
			System.out.print(t + "\t ");
		} // ���� ���
		System.out.print("\n\t ���\t ");
		
		for(double a : avg) {
			System.out.print(a + "\t ");
		} // ��� ���
		System.out.println("\n�������������������������������������������������������������������");
		
		
	}

}
