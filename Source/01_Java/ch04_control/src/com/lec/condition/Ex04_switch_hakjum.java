package com.lec.condition;
import java.util.Scanner;
// 사용자로부터 점수를 입력받아 학점 출력 - switch-case문
public class Ex04_switch_hakjum {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("점수를 입력해주세요 : ");
		int score = sc.nextInt();
		int temp = score==100? score-1 : score; 
		// case 10이 발생될 경우, 101점 등이 A학점으로 출력되는 문제 발생을 위해
		// 100점을 -1을 해주어서 99점으로 만들어준다.
		temp = (-9<=temp && temp<0) ? -10 : temp;
		// -1점대의 친구들이 F학점으로 출력되는 문제를 해결하기 위한 삼항연산자.
		
		switch (temp / 10) {
		case 9:  // ** break 꼭 걸어주자!!!
			System.out.println("A");
			break;
		case 8: 
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		case 5: case 4: case 3: case 2: case 1: case 0: 
			System.out.println("F");
			break; //* break 꼭 입력하자!
		default:
			System.out.println("유효하지 않은 점수 입니다.");
		}
		
		sc.close();

	
	}

}
