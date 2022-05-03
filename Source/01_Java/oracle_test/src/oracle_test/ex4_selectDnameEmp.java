package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* 1. 사용자에게 부서명을 입력받아
* 		1-1. 부서존재하는 경우 : 부서정보와 사원정보(사번, 이름, 급여, 급여등급)를 출력
* 		1-2. 부서존재하지 않는 경우 : 없다고 출력    */
public class ex4_selectDnameEmp {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("부서명을 입력해주세요 : ");
		String dname = sc.next().toUpperCase();
		
		String sql1 = "SELECT * FROM DEPT WHERE DNAME = UPPER('"+dname+"')";
		sql1 = String.format("SELECT * FROM DEPT WHERE DNAME = UPPER('%s')", dname);
		
		
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, GRADE" + 
									"    FROM EMP E, DEPT D, SALGRADE S" + 
									"    WHERE E.DEPTNO = D.DEPTNO" + 
									"    AND E.SAL BETWEEN LOSAL AND HISAL" + 
									"    AND DNAME = UPPER('%s')", dname);
				
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			// sql1번 : dname 입력받기
			rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				System.out.println("부서번호 : " + rs.getInt("deptno") + " / 부서이름 : " + dname + " / 부서위치 : " + rs.getString("loc"));
				rs.close();

				// sql2 : dname 에 속한 사원 정보 출력
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					System.out.println(dname + " 부서 사원 정보 출력");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int grade = rs.getInt("grade");
						
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + grade);
						
					} while(rs.next());
				} else {
					System.out.println("해당 부서에 사원이 존재하지 않습니다.");
				}
			} else {
				System.out.println("입력하신 부서가 존재하지 않습니다.");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		
	} // main 
} // class
