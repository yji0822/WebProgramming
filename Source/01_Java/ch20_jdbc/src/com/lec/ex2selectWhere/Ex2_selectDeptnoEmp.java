package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* 1. 사용자에게 부서번호 입력 받아
 * 1-1 해당부서번호가 존재할 경우 ; 해당부서 정보와 해당부서 사원(사번,이름,급여,상사명 - self join)을 출력
 * 1-2 해당부서번호가 존재하지 않을 경우 ; 없다고 출력
 * sql문을 두번 돌리는 것!
 */
public class Ex2_selectDeptnoEmp {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		// 필요한 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner (System.in);
		System.out.print("원하는 부서 번호는? ");
		int deptno = sc.nextInt(); // string으로 받아도 무방
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO =" + deptno;
		String sql2 = " SELECT W. EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER" + 
				"        FROM EMP W, EMP M" + 
				"        WHERE W.MGR = M.EMPNO" + 
				"            AND W.DEPTNO = " + deptno;
		
		try {
			Class.forName(driver); // 1
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
			stmt = conn.createStatement(); // 3
			rs   = stmt.executeQuery(sql1); // 4,5 - 1번 쿼리 실행 - deptno, dname, loc
			if(rs.next()) { // 해당 부서가 있는 경우
				// 부서정보랑 해당 부서 사원정보 뿌리기
				System.out.println("부서번호 : " + deptno);
				System.out.println("부서이름  : " + rs.getString("dname"));
				System.out.println("부서위치 : " + rs.getString("loc"));
				
				rs.close(); // 기존의 rs를 해제 시키고 다시 받는다
				rs = stmt.executeQuery(sql2); // 사원정보 받아오는 sql2 - empno, ename, sal, manager
				if(rs.next()) {
					System.out.println("사번 \t 이름\t 급여 \t 상사명");
					// 출력
					do {
						int empno      = rs.getInt("empno"); 
						String ename   = rs.getString("ename");
						int sal        = rs.getInt("sal");
						String manager = rs.getString("manager"); // m.ename - 별칭설정 필수!
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + manager);
					} while (rs.next());
				} else {
					System.out.println(deptno + "번 부서 사원은 없습니다.");
				}
			} else { // 입력한 부서가 없는 경우
				System.out.println(deptno + "번 부서는 존재하지 않습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		

	} // main

} // class
