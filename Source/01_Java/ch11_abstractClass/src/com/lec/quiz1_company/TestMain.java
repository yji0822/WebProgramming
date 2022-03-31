package com.lec.quiz1_company;

public class TestMain {

	public static void main(String[] args) {
		
		Employee[] sawon = { new SalaryEmployee("홍길동", 24000000),
				             new SalaryEmployee("강동원", 70000000),
							 new SalaryEmployee("김고은", 12000000),
							 new HourlyEmployee("홍길구", 100, 7000),
							 new HourlyEmployee("김길자", 120, 8000)};
		for(Employee temp : sawon) {
			System.out.println("~~~ 월급명세서 ~~~");
			System.out.println("성함 : " + temp.getName());
			System.out.println("월급 : " + temp.computePay());
			int tempIncen = temp.computeIncentive();
			if(tempIncen != 0) {
				System.out.println("상여 : " + tempIncen);
			}
			/* if(temp.computeIncentive() !=0) {
			 * sysout("상여 : " + temp.computeincentive());
			 * 가능하지만 함수가 여러번 호출되면  왔다갔다 해야하기 때문에 변수에 넣어주자!!!
			 */
		}

	}

}
