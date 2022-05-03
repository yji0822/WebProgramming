package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 원하는 부서번호를 입력받아 부서정보 출력
public class Ex1_selectDeptno {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner (System.in);
		System.out.print("원하는 부서 번호는? ");
		int deptno = sc.nextInt(); // string으로 받아도 무방
		String sql = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		
		try {
			Class.forName(driver); // 1
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
			stmt = conn.createStatement(); // 3
			rs = stmt.executeQuery(sql); // 4+5
			
			// 결과가 많아도 1줄 적으면 0줄일 경우 if문 사용 deptno는 dept의 primary key
			if(rs.next()) { // 해당부서가 있음
				// deptno + dname + loc 출력
				System.out.println(deptno +" 번 부서정보는 다음과 같습니다.");
				System.out.println("부서이름 : " + rs.getString("dname"));
				System.out.println("부서위치 : " + rs.getString("loc"));
			} else { // 해당부서가 없음
				System.out.println(deptno + "번 부서는 존재하지 않습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} // 1
		catch (SQLException e) {
	 		System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
	} // main
} // class
