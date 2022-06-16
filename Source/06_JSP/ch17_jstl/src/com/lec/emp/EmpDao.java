package com.lec.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDao {

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection(); // tiger, scott, 이런거 잘못 입력하면 에러 발생 - 예외처리 throws SQLException
		} catch (NamingException e) {
			System.out.println("커넥션 풀 이름 오류 : " + e.getMessage());
		}
		return conn;
	} // getConncetion()
	
	public ArrayList<EmpDto> listEmp() {
		// 검색결과
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP";
		
		try {
			conn= getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int empno = rs.getInt("empno");
				 String ename = rs.getString("ename");
				 String job = rs.getString("job");
				 int mgr = rs.getInt("mgr");
				 Date hiredate = rs.getDate("hiredate");
				 int sal = rs.getInt("sal");
				 int comm = rs.getInt("comm");
				 int deptno = rs.getInt("deptno");
				 
				 emps.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
				 
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
		return emps;
	} // listEmp
	
	public ArrayList<EmpDto> listEmp(String schName, String schJob) {
		// 매개변수로 사용자에게 받은 이름과 직업을 넣어준다.
		// null이냐 null이 아니냐는 서블릿에서 판가름 해준다.
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP WHERE ENAME "
					+ "LIKE '%'||UPPER(?)||'%' AND JOB LIKE '%'||UPPER(?)||'%'";
		
		try {
			conn= getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schName);
			pstmt.setString(2, schJob);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int empno = rs.getInt("empno");
				 String ename = rs.getString("ename");
				 String job = rs.getString("job");
				 int mgr = rs.getInt("mgr");
				 Date hiredate = rs.getDate("hiredate");
				 int sal = rs.getInt("sal");
				 int comm = rs.getInt("comm");
				 int deptno = rs.getInt("deptno");
				 
				 emps.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // finally
		return emps;
	} // listEmp
	
}
