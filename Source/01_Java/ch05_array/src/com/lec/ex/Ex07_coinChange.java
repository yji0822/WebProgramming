package com.lec.ex;
// 거스름돈 2680원을 500원, 100원, 50원, 10원짜리 동전으로 거슬러 줄 때, 
// 각각 몇개씩 주어야 하는지 출력하시오.
public class Ex07_coinChange {

	public static void main(String[] args) {
		
		int[] coin = {500, 100, 50, 10};
		int money = 2680;
		
		for(int i=0; i<coin.length; i++) {
			System.out.print(coin[i] + "원 짜리 " + (money/coin[i]) + "개 \t");
		}


	}

}
