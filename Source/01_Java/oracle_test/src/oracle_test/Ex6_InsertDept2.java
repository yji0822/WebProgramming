package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex6_InsertDept2 {
// 부서번호를 입력받아 중복체크 진행 후 입력 진행
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner (System.in);
		System.out.print("부서번호 입력 : ");
		int deptno = sc.nextInt();
		
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSql);
			
			if(!rs.next()) {
				System.out.println("입력하신 번호는 " + deptno + "번, 부서 입력 진행");
				rs.close();
				
				System.out.print("부서명 입력:");
				String dname = sc.next();
				System.out.print("부서위치 입력 : ");
				String loc = sc.next();
				
				String inserSql = String.format("INSERT INTO DEPT VALUES (deptno, '%s', '%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(selectSql);
				if(result>0) {
					System.out.println("입력성공");
				}
				
			} else {
				System.out.println("부서번호 중복.... 입력 불가");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	} // main
} // class
