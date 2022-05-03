package com.lec.ex3insert;
// primary key �������� ���� 
// ORA-00001: unique constraint (SCOTT.SYS_C006997) violated
// oracle Ʈ����ǿ� INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL'); �Էµ� ����
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Scanner sc = new Scanner (System.in);
		System.out.print("�μ���ȣ �Է� : ");
		int deptno = sc.nextInt();
		System.out.print("�μ��� �Է� : ");
		String dname = sc.next();
		System.out.print("�μ���ġ �Է� : ");
		String loc = sc.next();
		
		String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"', '"+loc+"')";
		sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
		// JAVA�� INSERT�� �� �Ŀ� �ڵ� COMMIT�� �Ǿ� �����ͺ��̽��� ������ �ȴ�.
		
		Connection conn = null;
		Statement  stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate(sql); // 4,5
			System.out.println(result > 0 ? "�Է� ����" : "�Է� ����"); 
			// 6 �����Ͱ� �ԷµȰ��� �ƴ��� Ȯ�� / oracle ������ insert�ϰ� commit�� ���ϸ� �������� ���Եȴ�.
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL���� : " + e.getMessage());
		} finally {
			try {
			
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
	} // main
} // class
