package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자로부터 삭제하고자 하는 부 서번호를 입력받아 삭제하기
public class DeleteDept {

	public static void main(String[] args) {
		// 부서번호가 있는지 없는지 확인 안해도 된다.
		
		// 드라이버랑 url 연결
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Scanner sc = new Scanner (System.in);
		
		Connection conn = null; // 연결객체
		Statement stmt  = null; // 전송객체
		// resultset - 결과를 전송받고 출력하는 것 (select)
		
		System.out.print("삭제할 부서번호를 입력해주세요 : ");
		int deptno = sc.nextInt();
		
		String sql = "DELETE FROM DEPT WHERE DEPTNO = " + deptno;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // static method
			stmt = conn.createStatement(); // sql 전송객체 생성
			
			int result = stmt.executeUpdate(sql); // 결과 출력하거나 오류 생성
			System.out.println(result > 0 ? deptno + " 번 부서 삭제 성공" : deptno + " 번 부서는 존재하지 않습니다.");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("sql 오류: " +e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
	} // main
} // class
