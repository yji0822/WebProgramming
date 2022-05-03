package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 부서번호를 입력받아 중복체크 확인 후 입력 진행 - while 사용
public class Ex7_InserDept3 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner (System.in);

			
		while(true) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				stmt = conn.createStatement();

				System.out.print("부서번호 입력 : ");
				int deptno = sc.nextInt();
				
				String selectSql = String.format("SELECT * FROM DEPT WHERE DEPTNO = %d", deptno);
				rs = stmt.executeQuery(selectSql);
				
				if(rs.next()) {
					System.out.println("동일한 부서번호 존재");
					continue;
				} else {
					System.out.println("부서 이름 입력");
					String dname = sc.next();
					System.out.println("부서 위치 입력");
					String loc = sc.next();
					
					String intserSql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
					int result= stmt.executeUpdate(intserSql);
					System.out.println(result>0 ? "입력성공" : "입력실패");
					break;
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt !=null) stmt.close();
					if(conn!=null) conn.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
	}

}
