package com.lec.ex09_super;

public class TestMain {

	public static void main(String[] args) {
		
		Person papa = new Person(); // name null, char = null - 매개변수=파라미터=인자가 없는 Person 생성자
		papa.setName("아빠곰");
		papa.setCharacter("뚱뚱해");
		papa.intro(); // 아빠곰은(는) 뚱뚱해
		
		System.out.println();
		Person mom = new Person("엄마곰", "날씬해"); // 매개변수 2개짜리 Person 생성자
		mom.intro(); // 엄마곰은(는) 날씬해
		
		System.out.println();
		Baby child1 = new Baby();
//		매개변수=파라미터=인자가 없는 Person 생성자
//		매개변수 없는 Baby 생성자
		child1.setName("아기곰1");
		child1.setCharacter("귀여워");
		child1.intro();
		
		System.out.println();
		Baby child2 = new Baby("아기곰2", "너무귀여워");
		child2.intro();		
//		응애응애 난 아가야
//		아기곰2은(는) 너무귀여워

	}

}
