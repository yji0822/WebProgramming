package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test01 {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
			System.out.println("����̹� �ε� ����");
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
		
	} // main
} // class
