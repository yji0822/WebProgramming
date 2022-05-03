package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڷκ��� �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ����Ͻÿ�
public class Ex2_select {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Scanner sc = new Scanner (System.in);
		
		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + 
				"    FROM EMP E, DEPT D" + 
				"    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER(?)";
		
		System.out.print("�μ��� : ");
		String dname = sc.next();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // sql(�Ű�����) ��� �ʼ�!
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // �ش� �μ� ����� �ִ� ��� list ���
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int sal = rs.getInt("sal");
					
					if(job.length() >= 8) {
						System.out.println(empno + "\t" + ename + "\t" + job + "\t" + sal);
					} else {
						System.out.println(empno + "\t" + ename + "\t" + job + "\t\t" + sal);
					}
				} while(rs.next()); // do-while
				} else {
					System.out.println("�ش� �μ����� ��������� �������� �ʽ��ϴ�.");
				} // if-else
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) 		rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null) 	conn.close();
			} catch (SQLException e) {}
		}
		
		
		
		
		
		
	}

}
