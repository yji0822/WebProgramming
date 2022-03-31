package ch06_beforOOP;
// 1~10 까지 정수의 합을 출력하고, 그 합이 짝수인지 홀수인지 출력
public class Ex01 {

	public static void main(String[] args) {
		int tot = sum(10); // sum(int to)
		System.out.println("1~10까지의 누적합은 " + tot);
		System.out.println(evenOdd(tot));

		tot = sum(1,10); // sum(int from, int to)
		System.out.println("1~10까지의 누적합: " + tot);
		System.out.println(evenOdd(tot));

	}
	
	private static int sum(int to) {
		int result = 0;
		for(int i=0; i<=10; i++) {
			result += i;
		}
		return result;
	}
	
	private static int sum(int from, int to) {
		int result = 0;
		for(int i=from; i<=to; i++) {
			result += i;
		}
		return result;
	}
	
	private static String evenOdd(int value) {
		return value%2 == 0 ? "짝수" : "홀수"; // 삼항연산자
		
	}
	
	

}
