package com.lec.ex3insert;
// �μ���ȣ�� �Է¹޾� �ߺ�üũ Ȯ�� ��, �Է� ����
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept2 {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner (System.in);
		System.out.print("�μ���ȣ �Է� : ");
		int deptno = sc.nextInt();
		// ** �μ���ȣ(PRIMARY KEY) �ߺ�üũ ** 
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = " + deptno;		
		
		// 1~7 �ܰ�
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(selectSQL); // 1��1��¥��(cnt) rs��ü�� �޾ƿ��� ���̱� ������ 
			rs.next();
			int cnt = rs.getInt("cnt"); // 0 or 1
			if(cnt == 1) {
				System.out.println("�ߺ��� �μ���ȣ�Դϴ�.");
			} else {
				System.out.print("�μ��� �Է� : ");
				String dname = sc.next();
				System.out.print("�μ���ġ �Է� : ");
				String loc = sc.next();
				
				String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", 
									 deptno, dname, loc);
				int result = stmt.executeUpdate(sql); // ���� ����� ������ 0 or 1
				System.out.println(result > 0 ? "�Է� ����" : "�Է� ����"); // ���� result�� 0�� ���� ����.
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL���� : " + e.getMessage());
		} finally {
			try {
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
	} // main
} // class
