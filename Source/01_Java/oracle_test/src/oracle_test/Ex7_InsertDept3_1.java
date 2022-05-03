package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 부서번호를 입력받은 후 중복체크 한 다음에 insert입력 진행
public class Ex7_InsertDept3_1 {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Scanner sc = new Scanner(System.in);

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			while(true) {
				System.out.println("부서번호 입력");
				int deptno = sc.nextInt();
				
				String selectSql = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
				rs = stmt.executeQuery(selectSql);
				
				if(rs.next()) {
					System.out.println("부서번호 존재. 다시 입력바람");
					continue;
				} else {
					System.out.println(deptno + "부서번호 중복 없음. 입력 진행");
					System.out.println("부서 이름 입력 : ");
					String dname = sc.next();
					System.out.println("부서 위치 입력 : ");
					String loc = sc.next();
					
					String insertSql = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"', '"+loc+"')";
//					String insertSql = String.format("INSERT INTO DEPT VALUES (deptno, '\"+dname+\"', '\"+loc+\"')\\\"", args)
					int result = stmt.executeUpdate(insertSql);
					if(result>0) {
						System.out.println("입력성공");
					} else {
						System.out.println("입력 실패");
					}
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
			}
		}

//		String insertSql = "INSERT INTO DEPT VALUES (deptno, '"+dname+"', '"+loc+"')";

	}
}
