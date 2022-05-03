package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			System.out.print("수정할 부서 번호 입력 : ");
			int deptno = sc.nextInt();
			// 입력한 부서번호가 있는지 없는지 체크 (생략)
			System.out.print("수정할 부서명 입력 : ");
			String dname = sc.next();
			System.out.print("수정할 부서 위치 : ");
			String loc = sc.next();
			// string은 생략
			String sql = "UPDATE DEPT SET DNAME = '"+dname+"', LOC = '"+loc+"' "
							+ "WHERE DEPTNO = " + deptno;
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "수정성공" : "해당부서는 존재하지 않습니다.");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
	} // main
} // class
