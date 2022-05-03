package com.lec.ex3_set;

public class Student {
	
	private int grade;
	private String name;
	
	// 생성자
	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}
	
	// 메소드
	@Override
	public String toString() {
		return grade + "학년 " + name;
	}

	// equals & hashcode 오버라이드
	@Override
	public boolean equals(Object obj) { // api object 오버라이드 참고하기
		if(obj != null && obj instanceof Student) {
//			boolean gradeChk = grade == ((Student)obj).grade;
//			boolean nameChk = name.equals(((Student)obj).name);
//			return gradeChk && nameChk;
			return toString().equals(obj.toString()); 
			// grade+"학년"+name; 이랑 obj의 tostring이 같으면 같다고 출력.
		}
		return false;
	}
	@Override
	public int hashCode() {
		return toString().hashCode(); // 출력된 값이 똑같으면 같은 hashCode()를 출력하도록
	}
	
	

}
