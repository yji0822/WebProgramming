package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ���ϴ� �μ���ȣ�� �Է¹޾� �μ����� ���
public class Ex1_selectDeptno {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner (System.in);
		System.out.print("���ϴ� �μ� ��ȣ��? ");
		int deptno = sc.nextInt(); // string���� �޾Ƶ� ����
		String sql = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		
		try {
			Class.forName(driver); // 1
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
			stmt = conn.createStatement(); // 3
			rs = stmt.executeQuery(sql); // 4+5
			
			// ����� ���Ƶ� 1�� ������ 0���� ��� if�� ��� deptno�� dept�� primary key
			if(rs.next()) { // �ش�μ��� ����
				// deptno + dname + loc ���
				System.out.println(deptno +" �� �μ������� ������ �����ϴ�.");
				System.out.println("�μ��̸� : " + rs.getString("dname"));
				System.out.println("�μ���ġ : " + rs.getString("loc"));
			} else { // �ش�μ��� ����
				System.out.println(deptno + "�� �μ��� �������� �ʽ��ϴ�.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} // 1
		catch (SQLException e) {
	 		System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
	} // main
} // class
