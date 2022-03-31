package com.lec.ex1_student;

public class StudentTestMain1 {

	public static void main(String[] args) {		
		// 이름 국어 영어 수학
		Student1[] student = {new Student1("정우성", 90, 90, 90),
							  new Student1("김하늘", 90, 90, 91),
							  new Student1("황정민", 80, 80, 80),
							  new Student1("강동원", 80, 80, 81),
							  new Student1("유아인", 70, 70, 70)};
		int[] tot = new int[5]; // tot[0] 국어누적, tot[1] 영어누적... tot[4] 평균누적
		double[] avg = new double[5]; // 평균저장 avg[0]국어평균 avg[1]영어평균...avg[4]평균의 평균
		// 배열의 초기값은 모두 0이다!
		
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t\t성\t적\t표 ");
		System.out.println("------------------------------------------------------------------");
		System.out.println("                  이름           국어           영어            수학             총점             평균");
		System.out.println("------------------------------------------------------------------");
		for(Student1 s : student) {
			s.Disp(); // 출력후 누적
			tot[0] += s.getKor(); // 국어 누적
			tot[1] += s.getEng();
			tot[2] += s.getMath();
			tot[3] += s.getTot();
			tot[4] += s.getAvg(); // 자동으로 형변환
		}
		for(int idx=0 ; idx<avg.length; idx++) { // 출력할 평균 계산 avg[0] = tot[0]/5
												 // avg[1] = tot[1]/5
												 // avg[4] = tot[4]/5 
			avg[idx] = (double)tot[idx]/student.length; // 소수점이 안들어가서 형변환!
		}
		System.out.println("------------------------------------------------------------------");
		System.out.print("\t총점\t");
		for(int t : tot) {
			System.out.print(t + "\t");
		} // 총점 출력
		System.out.print("\n\t평균\t");
		for(double a : avg) {
			System.out.print(a + "\t");
		} // 평균 출력
		System.out.println("\n■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		
		
	}

}
