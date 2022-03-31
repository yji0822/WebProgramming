package com.lec.ex;
// 할당(대입)연산자 : =  +=  -=  *=  /=  %=
public class Ex07 {

	public static void main(String[] args) {
		int n1 = 10*3; // =도 할당연산자!
		n1 += 10; // n1 = n1+10;
		System.out.println("n1 = " +n1);
		n1 -= 10; // n1 = n1-10;
		n1 *= 10; // n1 = n1*10;
		int n2 = n1 = 10; // 10을 n1에 넣고 n1값을 n2에 대입 = 10
		System.out.println(n1); // 10
		System.out.println(n2); // 10
		
		System.out.println("n1을 1증가하고 싶을때 쓰는 연산자 모음");
		n1 +=1;
		System.out.println("n1+=1;  " + n1);
		n1++;
		System.out.println("n1++;   " + n1);
		++n1;
		System.out.println("++n1;   " + n1);
		n1 = n1+1;
		System.out.println("n1=n1+1 " + n1);
		
	}

}
