package com.lec.ch14.dao;

import java.util.List;

import com.lec.ch14.dto.Emp;

public interface EmpDao {
	public List<Emp> empList(Emp schEmp);
	// 반드시 emp.xml에 있는 parameterType의 이름과 동일하게 만들어준다.
	
}
