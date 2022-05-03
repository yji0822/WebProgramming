package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex6_InsertDept2 {
// �μ���ȣ�� �Է¹޾� �ߺ�üũ ���� �� �Է� ����
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner (System.in);
		System.out.print("�μ���ȣ �Է� : ");
		int deptno = sc.nextInt();
		
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSql);
			
			if(!rs.next()) {
				System.out.println("�Է��Ͻ� ��ȣ�� " + deptno + "��, �μ� �Է� ����");
				rs.close();
				
				System.out.print("�μ��� �Է�:");
				String dname = sc.next();
				System.out.print("�μ���ġ �Է� : ");
				String loc = sc.next();
				
				String inserSql = String.format("INSERT INTO DEPT VALUES (deptno, '%s', '%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(selectSql);
				if(result>0) {
					System.out.println("�Է¼���");
				}
				
			} else {
				System.out.println("�μ���ȣ �ߺ�.... �Է� �Ұ�");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	} // main
} // class
