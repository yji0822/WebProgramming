package com.lec.quiz04_customer;

import java.util.ArrayList;

public class Test {

	
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();	
		
		System.out.println("2번테스트");
	      ArrayList<CustomerDto> dto = dao.cTelgetCustomer("010-1111-1111");
	      for(CustomerDto d : dto) {
	         System.out.println(d);
	      }
	}

}
