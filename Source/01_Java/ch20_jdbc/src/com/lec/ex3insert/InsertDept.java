package com.lec.ex3insert;
// primary key 제약조건 위반 
// ORA-00001: unique constraint (SCOTT.SYS_C006997) violated
// oracle 트랜잭션에 INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL'); 입력된 상태
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Scanner sc = new Scanner (System.in);
		System.out.print("부서번호 입력 : ");
		int deptno = sc.nextInt();
		System.out.print("부서명 입력 : ");
		String dname = sc.next();
		System.out.print("부서위치 입력 : ");
		String loc = sc.next();
		
		String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"', '"+loc+"')";
		sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
		// JAVA는 INSERT를 한 후에 자동 COMMIT이 되어 데이터베이스에 저장이 된다.
		
		Connection conn = null;
		Statement  stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate(sql); // 4,5
			System.out.println(result > 0 ? "입력 성공" : "입력 실패"); 
			// 6 데이터가 입력된건지 아닌지 확인 / oracle 내에서 insert하고 commit을 안하면 무한으로 돌게된다.
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		} finally {
			try {
			
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
	} // main
} // class
