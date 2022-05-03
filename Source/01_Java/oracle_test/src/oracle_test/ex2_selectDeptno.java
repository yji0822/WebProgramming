package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ���ϴ� �μ���ȣ�� �Է¹��� �� �μ����� ���
public class ex2_selectDeptno {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�μ���ȣ �Է� : ");
		int deptno = sc.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println(deptno + " �� �μ� ����");
				System.out.println("�μ� �̸� : " + rs.getString("dname") + " �μ���ġ : " + rs.getString("loc"));
			} else {
				System.out.println("�Է��Ͻ� �μ� ������ �������� �ʽ��ϴ�.");
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
			} catch (SQLException e) {}
			
		}
		

	}

}
