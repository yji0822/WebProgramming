package com.lec.ex14_account;

public class TestMain {

	public static void main(String[] args) {

		Account a1 = new Account("111-1111", "홍길동");
		a1.deposit(3000); // 입금
		a1.deposit(6000); 
		a1.withdraw(10000); // 출금잔액부족
		
		System.out.println("___________________________________________________");
		CheckingAccount a2 = new CheckingAccount("222-2222", "신길동", 1000, "1111-2222-3333-4444");
		a2.deposit(9000);
		a2.withdraw(20000);
		a2.pay("1234-5678-9012-3456", 2000);
		a2.pay("1111-2222-3333-4444", 30000);
		a2.pay("1111-2222-3333-4444", 30000);
		a2.pay("1111-2222-3333-4444", 8000);
		
		System.out.println("___________________________________________________");
		CreditLineAccount a3 = new CreditLineAccount("3333-333", "홍길순", 10000,
				"1111-1111", 100000);
		a3.deposit(10000);
		a3.pay("1111-1111", 10000);
	
		
	}
	
}
