package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex5_insertDept {
// dept 클래스 부서 추가
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		// DEPT = DEPTNO, DNAME, LOC
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호 : ");
		int deptno = sc.nextInt();
		System.out.print("부서이름 : ");
		String dname = sc.next();
		System.out.print("부서 위치 : ");
		String loc = sc.next();
		
		String sql = "INSERT INTO DEPT VALUES (10, 'LOVE', 'SEOUL')";
		sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname.toUpperCase(), loc.toUpperCase());
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "부서정보 입력 성공" : "부서정보 입력 실패");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
			}
			
		}
		
		
	}

}
