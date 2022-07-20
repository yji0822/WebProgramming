package com.lec.ch14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch14.dao.DeptDao;
import com.lec.ch14.dao.EmpDao;
import com.lec.ch14.dto.Dept;
import com.lec.ch14.dto.Emp;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private DeptDao deptDao;
	@Autowired
	private EmpDao empDao;
	
	@Override
	public List<Dept> deptList() {
		return deptDao.deptList();
	}

	@Override
	public List<Emp> empList(Emp schEmp) {
		
		// 소문자를 대문자로 처리해주는 로직 작성
		if(schEmp.getEname() != null) {
			schEmp.setEname(schEmp.getEname().toUpperCase());
		}
		if(schEmp.getJob() != null) {
			schEmp.setJob(schEmp.getJob().toUpperCase());
		}
		
		return empDao.empList(schEmp);

	}

}
