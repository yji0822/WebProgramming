package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڷκ��� �����ϰ��� �ϴ� �� ����ȣ�� �Է¹޾� �����ϱ�
public class DeleteDept {

	public static void main(String[] args) {
		// �μ���ȣ�� �ִ��� ������ Ȯ�� ���ص� �ȴ�.
		
		// ����̹��� url ����
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Scanner sc = new Scanner (System.in);
		
		Connection conn = null; // ���ᰴü
		Statement stmt  = null; // ���۰�ü
		// resultset - ����� ���۹ް� ����ϴ� �� (select)
		
		System.out.print("������ �μ���ȣ�� �Է����ּ��� : ");
		int deptno = sc.nextInt();
		
		String sql = "DELETE FROM DEPT WHERE DEPTNO = " + deptno;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // static method
			stmt = conn.createStatement(); // sql ���۰�ü ����
			
			int result = stmt.executeUpdate(sql); // ��� ����ϰų� ���� ����
			System.out.println(result > 0 ? deptno + " �� �μ� ���� ����" : deptno + " �� �μ��� �������� �ʽ��ϴ�.");
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ���� : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("sql ����: " +e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
	} // main
} // class
