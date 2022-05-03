package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// dname 출력
/* 1. 사용자에게 부서명을 입력받아
 * 	1-1 부서가 존재하는 경우 ; 부서정보와 사원정보(사번, 이름,급여, 급여등급) 을 출력
 * 	1-2. 부서가 존재하지 않는 경우 : 없다고 출력
 */
public class Ex3_selectDname {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		// select 전송에 필요한 변수 선언
		Connection conn = null; // 연결
		Statement stmt = null; 	// sql문 전송
		ResultSet rs = null; 	// select문 전송
		
		Scanner sc = new Scanner (System.in);
		System.out.print("부서명을 입력하세요 : ");
		String dname = sc.next();
		
		String sql1 = "SELECT * FROM DEPT WHERE DNAME = UPPER('"+dname+"')";
		sql1 = String.format("SELECT * FROM DEPT WHERE DNAME = UPPER('%s')", dname); // printf와 같은 방식
		
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, GRADE" + 
									"    FROM EMP E, SALGRADE, DEPT D" + 
									"    WHERE SAL BETWEEN LOSAL AND HISAL" + 
									"        AND E.DEPTNO = D.DEPTNO" + 
									"        AND DNAME = UPPER('%s')", dname);
		try {
			Class.forName(driver); // 1. 드라이버로드
			conn = DriverManager.getConnection(url, "scott", "tiger"); // sql접속
			stmt = conn.createStatement(); // 3. sql전송
			rs   = stmt.executeQuery(sql1); // sql selet문 쏘기
			
			if(rs.next()) { // 6. 부서정보, 사원정보 출력
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서이름 : " + rs.getString("dname")); 
				System.out.println("부서이름 : " + dname.toUpperCase());
				System.out.println("부서위치 : " + rs.getString("loc"));
				rs.close();
				
				rs = stmt.executeQuery(sql2); // 4+5
				if(rs.next()) { // 해당부서명의 사원이 있는 경우 - 첫번째 줄은 이미 실행한 상태
					System.out.println("사번 \t 이름\t 급여 \t 등급");
					System.out.println("===========================");
					do {
						int empno    = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal      = rs.getInt("sal");
						int grade    = rs.getInt("grade");
						// 출력
						System.out.println(empno +"\t" + ename +"\t" + sal + "\t" + grade +"등급");
					} while (rs.next());
				} else { // 부서는 존재하나, 사원이 존재하지 않는 경우
					System.out.println(dname + "부서에 사원이 존재하지 않습니다.");
				}
			} else {
				System.out.println(dname + "부서는 존재하지 않습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // 7. close
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {}
			
		}
		
		
		
	} // main
} // class
