package com.lec.ex;
// �Ҵ�(����)������ : =  +=  -=  *=  /=  %=
public class Ex07 {

	public static void main(String[] args) {
		int n1 = 10*3; // =�� �Ҵ翬����!
		n1 += 10; // n1 = n1+10;
		System.out.println("n1 = " +n1);
		n1 -= 10; // n1 = n1-10;
		n1 *= 10; // n1 = n1*10;
		int n2 = n1 = 10; // 10�� n1�� �ְ� n1���� n2�� ���� = 10
		System.out.println(n1); // 10
		System.out.println(n2); // 10
		
		System.out.println("n1�� 1�����ϰ� ������ ���� ������ ����");
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
