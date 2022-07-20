package com.lec.ch14.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch14.dto.Dept;

@Repository
public class DeptDaoImpl implements DeptDao {
	
	@Autowired
	private SqlSession sessionTemplate; // dept리스트 수행해라 라는 의미
	
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList");
		// id가 deptList라는 것을 불러와서 수행하라는 의미
	}

}
