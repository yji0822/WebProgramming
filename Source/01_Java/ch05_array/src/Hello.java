// Hello.java --(컴파일 javac Hello.java)--> Hello.class 
// --(실행 java Hello 장동건 고소영)--> 결과
public class Hello {
	public static void main(String[] args) {
		// String[] args의 의미
		// String 배열의 args라는 객체명
		System.out.print("안녕하세요");
		for(int idx=0; idx<args.length; idx++) {
			System.out.print(", " + args[idx]);
		}
		
		// 1. bin/cmd 에서 하는 것
		// Hello 실행한번 하고 컴파일
		// bin에서 cmd 창 들어가서 .... java Hello 작성해서 안녕하세요 뜨는지 확인하고...
		// java Hello 옆에 장동건 고소영 입력하면... 출력되는걸 알 수 있음...
		
		// 2. 메뉴
		// Run > RunConfigurations > Arguments.... 누르고 내가 추가하고 싶은것 추가하기.
	
	}

}
