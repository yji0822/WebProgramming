package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connOracle {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // ip�ּ�: ���Ǿ��� ����
		
		Connection conn = null;
		
		try {
			// 1�ܰ�: ����̹� �ε�
			Class.forName(driver); // ���� ó�� �ϱ�
			System.out.println("����̹� �ε� ����");
			// 2�ܰ�: db�� ���� ��ü ����
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("orcle DB���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ���� : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB���� ���� : " + e.getMessage());
		} finally {
			// ���� ��ü ���� ��
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	} // main
} 
