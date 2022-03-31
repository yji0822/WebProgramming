package com.lec.ex8_student;

public class StudentTestMain {

	public static void main(String[] args) {
		
		Student[] student = {new Student("정우성", 90, 91, 91),
							 new Student("김하늘", 100, 80, 95),
							 new Student("황정민", 95, 80, 90),
							 new Student("강동원", 80, 80, 81),
							 new Student("유아인", 70, 70, 70)};
		
		int[] tot = new int[5]; // 총합누적
		double[] avg = new double[5]; // 평균 누적

		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t\t성\t적\t표 ");
		System.out.println("------------------------------------------------------------------");
		System.out.println("  번호\t 이름\t 국어\t 영어\t 수학\t 총점\t 평균");
		System.out.println("------------------------------------------------------------------");
		for(Student s : student) {
			s.disp(); // 입력한 점수들 출력 후 누적
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMath();
			tot[3] += s.getTot();
			tot[4] += s.getAvg(); // 자동으로 형변환
		}
		for(int idx=0 ; idx<avg.length; idx++) { 
			avg[idx] = (double)tot[idx]/student.length; 
		}
		System.out.println("------------------------------------------------------------------");
		System.out.print("\t 총점\t ");
		for(int t : tot) {
			System.out.print(t + "\t ");
		} // 총점 출력
		System.out.print("\n\t 평균\t ");
		
		for(double a : avg) {
			System.out.print(a + "\t ");
		} // 평균 출력
		System.out.println("\n■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
		
	}

}
