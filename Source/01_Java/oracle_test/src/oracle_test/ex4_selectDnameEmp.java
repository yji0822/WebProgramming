package oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* 1. ����ڿ��� �μ����� �Է¹޾�
* 		1-1. �μ������ϴ� ��� : �μ������� �������(���, �̸�, �޿�, �޿����)�� ���
* 		1-2. �μ��������� �ʴ� ��� : ���ٰ� ���    */
public class ex4_selectDnameEmp {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�μ����� �Է����ּ��� : ");
		String dname = sc.next().toUpperCase();
		
		String sql1 = "SELECT * FROM DEPT WHERE DNAME = UPPER('"+dname+"')";
		sql1 = String.format("SELECT * FROM DEPT WHERE DNAME = UPPER('%s')", dname);
		
		
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, GRADE" + 
									"    FROM EMP E, DEPT D, SALGRADE S" + 
									"    WHERE E.DEPTNO = D.DEPTNO" + 
									"    AND E.SAL BETWEEN LOSAL AND HISAL" + 
									"    AND DNAME = UPPER('%s')", dname);
				
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			// sql1�� : dname �Է¹ޱ�
			rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				System.out.println("�μ���ȣ : " + rs.getInt("deptno") + " / �μ��̸� : " + dname + " / �μ���ġ : " + rs.getString("loc"));
				rs.close();

				// sql2 : dname �� ���� ��� ���� ���
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					System.out.println(dname + " �μ� ��� ���� ���");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int grade = rs.getInt("grade");
						
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + grade);
						
					} while(rs.next());
				} else {
					System.out.println("�ش� �μ��� ����� �������� �ʽ��ϴ�.");
				}
			} else {
				System.out.println("�Է��Ͻ� �μ��� �������� �ʽ��ϴ�.");
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
	
		
	} // main 
} // class
