package oracle_test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex1_selectAll {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM EMP";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
			
			// 전송객체 생성 및, 데이터 저장
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int    mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				if(job.length() >= 8) {
					System.out.println(empno + "\t" + ename +"\t" + job + "\t" + mgr + "\t" 
							+ hiredate + "\t" + sal + "\t" + comm + "\t" + deptno);				
				} else {
					System.out.println(empno + "\t" + ename +"\t" + job + "\t\t" + mgr + "\t" 
							+ hiredate + "\t" + sal + "\t" + comm + "\t" + deptno);				
				}	
			}
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
			
		}
		
		
	}

}
