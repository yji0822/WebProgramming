package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//사용자에게 부서번호를 입력받아
	// 1-1 해당부서가 존재할 경우 : 해당부서정보와 해당부서 사원 (사번, 이름, 급여, 상사명)
	// 1-2 해당부서가 존재하지 않을 경우 : 없다고 출력
public class ex3_selectDeptnoEmp_1 {

	public static void main(String[] args) {
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호를 입력하세요 : ");
		int deptno = sc.nextInt();
		
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME manager" + 
				"    FROM EMP W, EMP M" + 
				"    WHERE W.MGR = M.EMPNO" + 
				"    AND W.DEPTNO = " + deptno;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			
			if(rs.next()) {
				System.out.println("입력하신 부서번호 " + deptno + "번은 " + rs.getString("dname") + "부서입니다.");
				rs.close();
				
				rs = stmt.executeQuery(sql2);
				System.out.println("사번\t이름\t급여\t상사명");
				if(rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.println(empno + "\t" + ename + "\t" +sal + "\t" + manager );
					} while(rs.next());	
				} else {
					System.out.println("해당 부서에는 직원이 존재하지 않습니다.");
				}
				
			} else {
				System.out.println("입력하신 부서번호가 존재하지 않습니다.");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
			}
		}
		
		
		
	}

}
