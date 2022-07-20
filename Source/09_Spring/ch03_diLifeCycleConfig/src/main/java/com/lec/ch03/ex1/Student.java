package com.lec.ch03.ex1;

import java.util.ArrayList;

import lombok.Data;

@Data // getter와 setter, toString, equals
public class Student {
	
	private String name; 
	private int age;
	private ArrayList<String> hobby;
	private double height;
	private double weight;
	
	// 생성자를 어노테이션 사용하지 않고 내가 따로 생성 - 이름, 나이, 취미
	public Student(String name, int age, ArrayList<String> hobby) {
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}
	
	
}
