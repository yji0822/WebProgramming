package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// �μ���ȣ�� �Է¹޾� �ߺ�üũ Ȯ�� �� �Է� ���� - while ���
public class Ex7_InserDept3 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner (System.in);

			
		while(true) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				stmt = conn.createStatement();

				System.out.print("�μ���ȣ �Է� : ");
				int deptno = sc.nextInt();
				
				String selectSql = String.format("SELECT * FROM DEPT WHERE DEPTNO = %d", deptno);
				rs = stmt.executeQuery(selectSql);
				
				if(rs.next()) {
					System.out.println("������ �μ���ȣ ����");
					continue;
				} else {
					System.out.println("�μ� �̸� �Է�");
					String dname = sc.next();
					System.out.println("�μ� ��ġ �Է�");
					String loc = sc.next();
					
					String intserSql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
					int result= stmt.executeUpdate(intserSql);
					System.out.println(result>0 ? "�Է¼���" : "�Է½���");
					break;
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt !=null) stmt.close();
					if(conn!=null) conn.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
	}

}
