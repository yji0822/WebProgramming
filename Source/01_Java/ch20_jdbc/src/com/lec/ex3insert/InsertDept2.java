package com.lec.ex3insert;
// 부서번호를 입력받아 중복체크 확인 후, 입력 진행
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept2 {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner (System.in);
		System.out.print("부서번호 입력 : ");
		int deptno = sc.nextInt();
		// ** 부서번호(PRIMARY KEY) 중복체크 ** 
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = " + deptno;		
		
		// 1~7 단계
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(selectSQL); // 1행1열짜리(cnt) rs객체를 받아오는 것이기 때문에 
			rs.next();
			int cnt = rs.getInt("cnt"); // 0 or 1
			if(cnt == 1) {
				System.out.println("중복된 부서번호입니다.");
			} else {
				System.out.print("부서명 입력 : ");
				String dname = sc.next();
				System.out.print("부서위치 입력 : ");
				String loc = sc.next();
				
				String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", 
									 deptno, dname, loc);
				int result = stmt.executeUpdate(sql); // 실행 결과는 무조건 0 or 1
				System.out.println(result > 0 ? "입력 성공" : "입력 실패"); // 절대 result가 0인 경우는 없다.
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		} finally {
			try {
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
	} // main
} // class
