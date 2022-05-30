package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lec.dto.EmpDTO;

public class EmpDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	
	// 싱글톤 DAO
	private static EmpDAO instance; // null이 기본값 - 자기가 자기 클래스를 참조하는 변수
	public static EmpDAO getInstance() {
		if(instance == null) {
			instance = new EmpDAO();
		} 
		return instance;
	}
	
	private EmpDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	} // EmpDAO()

	// searchName을 매개변수로 받아 EmpDTO들 return
	public ArrayList<EmpDTO> selectSearchName(String searchName){
		
		ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();
		
		// 2단계 ~ 7단계 - 자바이기 때문에 반드시 try-catch
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER(?)||'%'";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// while문 한번도 안돌면 return dtos에서 0으로 리턴이 되기 때문에 if문 사용 안해도 된다.
				/*
				 * EmpDTO emp = new EmpDTO(); emp.setEmpno(rs.getInt("empno"));
				 * emp.setEname(rs.getString("ename")); emp.setJob(rs.getString("job"));
				 * emp.setMgr(rs.getInt("mgr")); emp.setHiredate(rs.getDate("hiredate"));
				 * emp.setSal(rs.getInt("sal")); emp.setComm(rs.getInt("comm"));
				 * emp.setDeptno(rs.getInt("deptno")); dtos.add(emp);
				 */
				
				 int empno = rs.getInt("empno"); 
				 String ename = rs.getString("ename"); 
				 String job = rs.getString("job"); 
				 int mgr = rs.getInt("mgr"); 
				 Date hiredate = rs.getDate("hiredate"); 
				 int sal = rs.getInt("sal"); 
				 int comm = rs.getInt("comm"); 
				 int deptno = rs.getInt("deptno");
				 
				 dtos.add(new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno));
				 
			} // while
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
	

	// deptno를 매개변수로 받아 EmpDTO들 return
	public ArrayList<EmpDTO> selectDeptno(int deptno) {
		// sql문만 바꿔주면 된다
		ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();
		
		// 2단계 ~ 7단계 - 자바이기 때문에 반드시 try-catch
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP WHERE DEPTNO=?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// while문 한번도 안돌면 return dtos에서 0으로 리턴이 되기 때문에 if문 사용 안해도 된다.
				/*
				 * EmpDTO emp = new EmpDTO(); emp.setEmpno(rs.getInt("empno"));
				 * emp.setEname(rs.getString("ename")); emp.setJob(rs.getString("job"));
				 * emp.setMgr(rs.getInt("mgr")); emp.setHiredate(rs.getDate("hiredate"));
				 * emp.setSal(rs.getInt("sal")); emp.setComm(rs.getInt("comm"));
				 * emp.setDeptno(rs.getInt("deptno")); dtos.add(emp);
				 */
				
				 int empno = rs.getInt("empno"); 
				 String ename = rs.getString("ename"); 
				 String job = rs.getString("job"); 
				 int mgr = rs.getInt("mgr"); 
				 Date hiredate = rs.getDate("hiredate"); 
				 int sal = rs.getInt("sal"); 
				 int comm = rs.getInt("comm"); 
				 // deptno = rs.getInt("deptno");
				 
				 dtos.add(new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno));
				 
			} // while
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
}
