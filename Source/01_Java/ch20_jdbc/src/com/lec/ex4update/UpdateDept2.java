package com.lec.ex4update;
// �����ϰ��� �ϴ� �μ���ȣ �Է� -> �����ϴ� �μ���ȣ���� üũ (�ߺ�üũ) -> �μ���� ��ġ�� �޾� ����
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept2 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // select��
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			System.out.print("������ �μ� ��ȣ �Է� : ");
			int deptno = sc.nextInt();
			// �Է��� �μ���ȣ�� �ִ��� ������ üũ - �ڹ� �ȿ� SQL���� �빮�ڷ� ���� ���� ��õ
			String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
			
			rs = stmt.executeQuery(selectSQL);
			if(rs.next()) {
				System.out.print("������ �μ��� �Է� : ");
				String dname = sc.next();
				System.out.print("������ �μ� ��ġ : ");
				String loc = sc.next();
				// string�� ����
				String sql = "UPDATE DEPT SET DNAME = '"+dname+"', LOC = '"+loc+"' "
								+ "WHERE DEPTNO = " + deptno;
				int result = stmt.executeUpdate(sql);
				System.out.println(result > 0 ? "��������" : "�ش�μ��� �������� �ʽ��ϴ�.");
			} else {
				System.out.println("�Է��Ͻ� �μ���ȣ " + deptno + "�� �������� �ʽ��ϴ�.");
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
		} // finally-try-catch
		
	} // main
} // class
