package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// dname ���
/* 1. ����ڿ��� �μ����� �Է¹޾�
 * 	1-1 �μ��� �����ϴ� ��� ; �μ������� �������(���, �̸�,�޿�, �޿����) �� ���
 * 	1-2. �μ��� �������� �ʴ� ��� : ���ٰ� ���
 */
public class Ex3_selectDname {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		// select ���ۿ� �ʿ��� ���� ����
		Connection conn = null; // ����
		Statement stmt = null; 	// sql�� ����
		ResultSet rs = null; 	// select�� ����
		
		Scanner sc = new Scanner (System.in);
		System.out.print("�μ����� �Է��ϼ��� : ");
		String dname = sc.next();
		
		String sql1 = "SELECT * FROM DEPT WHERE DNAME = UPPER('"+dname+"')";
		sql1 = String.format("SELECT * FROM DEPT WHERE DNAME = UPPER('%s')", dname); // printf�� ���� ���
		
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, GRADE" + 
									"    FROM EMP E, SALGRADE, DEPT D" + 
									"    WHERE SAL BETWEEN LOSAL AND HISAL" + 
									"        AND E.DEPTNO = D.DEPTNO" + 
									"        AND DNAME = UPPER('%s')", dname);
		try {
			Class.forName(driver); // 1. ����̹��ε�
			conn = DriverManager.getConnection(url, "scott", "tiger"); // sql����
			stmt = conn.createStatement(); // 3. sql����
			rs   = stmt.executeQuery(sql1); // sql selet�� ���
			
			if(rs.next()) { // 6. �μ�����, ������� ���
				System.out.println("�μ���ȣ : " + rs.getInt("deptno"));
				System.out.println("�μ��̸� : " + rs.getString("dname")); 
				System.out.println("�μ��̸� : " + dname.toUpperCase());
				System.out.println("�μ���ġ : " + rs.getString("loc"));
				rs.close();
				
				rs = stmt.executeQuery(sql2); // 4+5
				if(rs.next()) { // �ش�μ����� ����� �ִ� ��� - ù��° ���� �̹� ������ ����
					System.out.println("��� \t �̸�\t �޿� \t ���");
					System.out.println("===========================");
					do {
						int empno    = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal      = rs.getInt("sal");
						int grade    = rs.getInt("grade");
						// ���
						System.out.println(empno +"\t" + ename +"\t" + sal + "\t" + grade +"���");
					} while (rs.next());
				} else { // �μ��� �����ϳ�, ����� �������� �ʴ� ���
					System.out.println(dname + "�μ��� ����� �������� �ʽ��ϴ�.");
				}
			} else {
				System.out.println(dname + "�μ��� �������� �ʽ��ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // 7. close
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {}
			
		}
		
		
		
	} // main
} // class
