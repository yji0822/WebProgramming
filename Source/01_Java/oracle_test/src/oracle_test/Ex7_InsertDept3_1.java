package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// �μ���ȣ�� �Է¹��� �� �ߺ�üũ �� ������ insert�Է� ����
public class Ex7_InsertDept3_1 {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Scanner sc = new Scanner(System.in);

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			while(true) {
				System.out.println("�μ���ȣ �Է�");
				int deptno = sc.nextInt();
				
				String selectSql = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
				rs = stmt.executeQuery(selectSql);
				
				if(rs.next()) {
					System.out.println("�μ���ȣ ����. �ٽ� �Է¹ٶ�");
					continue;
				} else {
					System.out.println(deptno + "�μ���ȣ �ߺ� ����. �Է� ����");
					System.out.println("�μ� �̸� �Է� : ");
					String dname = sc.next();
					System.out.println("�μ� ��ġ �Է� : ");
					String loc = sc.next();
					
					String insertSql = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"', '"+loc+"')";
//					String insertSql = String.format("INSERT INTO DEPT VALUES (deptno, '\"+dname+\"', '\"+loc+\"')\\\"", args)
					int result = stmt.executeUpdate(insertSql);
					if(result>0) {
						System.out.println("�Է¼���");
					} else {
						System.out.println("�Է� ����");
					}
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
			}
		}

//		String insertSql = "INSERT INTO DEPT VALUES (deptno, '"+dname+"', '"+loc+"')";

	}
}
