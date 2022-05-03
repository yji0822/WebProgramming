package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex1_selectAll_1 {

	public static void main(String[] args) {
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM DEPT";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott" , "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("부서번호\t부서명\t\t지역");
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				if(dname.length() >=8) {
					System.out.println(deptno + "\t" + dname + "\t" + loc);
				} else {
					System.out.println(deptno + "\t" + dname + "\t\t" + loc);	
				}
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
		
	}

}
