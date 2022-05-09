package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//����ڿ��� �μ���ȣ�� �Է¹޾�
	// 1-1 �ش�μ��� ������ ��� : �ش�μ������� �ش�μ� ��� (���, �̸�, �޿�, ����)
	// 1-2 �ش�μ��� �������� ���� ��� : ���ٰ� ���
public class ex3_selectDeptnoEmp_1 {

	public static void main(String[] args) {
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�μ���ȣ�� �Է��ϼ��� : ");
		int deptno = sc.nextInt();
		
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME manager" + 
				"    FROM EMP W, EMP M" + 
				"    WHERE W.MGR = M.EMPNO" + 
				"    AND W.DEPTNO = " + deptno;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			
			if(rs.next()) {
				System.out.println("�Է��Ͻ� �μ���ȣ " + deptno + "���� " + rs.getString("dname") + "�μ��Դϴ�.");
				rs.close();
				
				rs = stmt.executeQuery(sql2);
				System.out.println("���\t�̸�\t�޿�\t����");
				if(rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.println(empno + "\t" + ename + "\t" +sal + "\t" + manager );
					} while(rs.next());	
				} else {
					System.out.println("�ش� �μ����� ������ �������� �ʽ��ϴ�.");
				}
				
			} else {
				System.out.println("�Է��Ͻ� �μ���ȣ�� �������� �ʽ��ϴ�.");
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
			}
		}
		
		
		
	}

}