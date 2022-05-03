package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* 1. ����ڿ��� �μ���ȣ �Է� �޾�
 * 1-1 �ش�μ���ȣ�� ������ ��� ; �ش�μ� ������ �ش�μ� ���(���,�̸�,�޿�,���� - self join)�� ���
 * 1-2 �ش�μ���ȣ�� �������� ���� ��� ; ���ٰ� ���
 * sql���� �ι� ������ ��!
 */
public class Ex2_selectDeptnoEmp {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		// �ʿ��� ���� ����
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner (System.in);
		System.out.print("���ϴ� �μ� ��ȣ��? ");
		int deptno = sc.nextInt(); // string���� �޾Ƶ� ����
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO =" + deptno;
		String sql2 = " SELECT W. EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER" + 
				"        FROM EMP W, EMP M" + 
				"        WHERE W.MGR = M.EMPNO" + 
				"            AND W.DEPTNO = " + deptno;
		
		try {
			Class.forName(driver); // 1
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
			stmt = conn.createStatement(); // 3
			rs   = stmt.executeQuery(sql1); // 4,5 - 1�� ���� ���� - deptno, dname, loc
			if(rs.next()) { // �ش� �μ��� �ִ� ���
				// �μ������� �ش� �μ� ������� �Ѹ���
				System.out.println("�μ���ȣ : " + deptno);
				System.out.println("�μ��̸�  : " + rs.getString("dname"));
				System.out.println("�μ���ġ : " + rs.getString("loc"));
				
				rs.close(); // ������ rs�� ���� ��Ű�� �ٽ� �޴´�
				rs = stmt.executeQuery(sql2); // ������� �޾ƿ��� sql2 - empno, ename, sal, manager
				if(rs.next()) {
					System.out.println("��� \t �̸�\t �޿� \t ����");
					// ���
					do {
						int empno      = rs.getInt("empno"); 
						String ename   = rs.getString("ename");
						int sal        = rs.getInt("sal");
						String manager = rs.getString("manager"); // m.ename - ��Ī���� �ʼ�!
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + manager);
					} while (rs.next());
				} else {
					System.out.println(deptno + "�� �μ� ����� �����ϴ�.");
				}
			} else { // �Է��� �μ��� ���� ���
				System.out.println(deptno + "�� �μ��� �������� �ʽ��ϴ�.");
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
		}
		

	} // main

} // class
