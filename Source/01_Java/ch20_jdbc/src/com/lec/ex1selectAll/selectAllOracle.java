package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class selectAllOracle {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null; // db ���� ��ü 
		Statement stmt = null; // sql �����ϴ� ��ü
		
		// (1) select ����� ������ - �ܼ��� ������ �ƴ�
		ResultSet rs = null; // SELECT�� ��� �޴� ��ü ����
		String query = "SELECT * FROM EMP";
		
		try {
			Class.forName(driver);                             // 1. ����̹� �ε�
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. db����
			stmt = conn.createStatement();                     // 3. sql�� ���� ��ü ����
			rs   = stmt.executeQuery(query);                   // 4. sql�� ���� + 5. sql ���� ��� ����
			
			// 6. ��� �޾� ���ϴ� ���� ���� (��� ���� ���� : rs)
			// ������ ������ �Ѹ��� ������ ������ ������ ���ٰ� ����Ű�� �۾�....
			// �����Ͱ� � �ִ��� �� - while������ ���
			// rs.next -> �޾ƿ� ���� ������ false ���
			
			System.out.println("��� \t�̸�\t��å\t\t�����\t�Ի���\t\t�޿�\t��\t�μ���ȣ"); // Ÿ��Ʋ ���
			
			while(rs.next()) { // 14�� ���ư��� while��
				// number�� ������ ���� int and String���� �޾Ƶ� �ȴ�.
				int    empno = rs.getInt("empno"); // ��ҹ��� ���� x, Ư������ ������ db �ʵ庰Ī ���� 
//				String empno = rs.getString("empno"); // �ʵ� ��Ī�� ������ ��Ī ��������, �ƴϸ� �׳� ������ �� ���
				String ename = rs.getString("ename");
				String job   = rs.getString("job");
				int    mgr   = rs.getInt("mgr");
//				Date   hiredate = rs.getDate("hiredate"); // (��õ) sql�� api �޾ƿ���
//				String hiredate = rs.getString("hiredate"); // (����) Date�Լ��� String���� �޾Ƶ� �� (�ð����� ���� ��µɰ�...?)
				Timestamp hiredate = rs.getTimestamp("hiredate"); // (��õ) sql api!
				int       sal      = rs.getInt("sal");
				int       comm     = rs.getInt("comm");
				int       deptno   = rs.getInt("deptno");
				
				// �ܼ� �󿡼��� ����ϴ� ����..(���� ���� �ϱ� ���ؼ�)
				if(job.length() >= 8) { // 8���� �̻��̸� �� �ѹ�
					System.out.printf("%d\t%s\t%s\t%d\t%TF\t%d\t%d\t%d\n",
								empno, ename, job, mgr, hiredate, sal, comm, deptno);
				} else { // 8���� �����̸� �� �ι�
					System.out.printf("%d\t%s\t%s\t\t%d\t%TF\t%d\t%d\t%d\n",
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
				} // if-else
			} // while
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // 7. �������� *** ��ü �� ���� �ݴ�� �ݾ��ֱ�!
			try {
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {	}
		} // finally - try- catch
		
		
		// select ���� ; executeQuery �Լ� �̿� / ��� : rs�� ����
		// (2) insert, update, delete - ����� 0, ������ ǥ���� �ȴ�.
		
	} // main
} // class

