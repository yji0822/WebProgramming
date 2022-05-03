package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// INSERT
public class Ex1_insertDept {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Scanner sc = new Scanner (System.in);
		
		// �ޱ����� sql �ۼ��ص� �ȴ�.
		// statement : sql ���� �ۼ��ϱ� ����  scanner �޾Ƽ� / preparedStatement : ?�� �޾ұ⶧���� ���� ��� ����
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)"; // Ȭ����ǥ�� ���� �ʼ�
		// �߰��� ������ �ޱ� - Scanner
		System.out.print("�߰��� �μ���ȣ : ");
		int deptno = sc.nextInt();
		System.out.print("�߰��� �μ��� : ");
		String dname = sc.next();
		System.out.print("�߰��� �μ� ��ġ : ");
		String loc = sc.next();
		
		// �����ͺ��̽� ����
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // (SQL ���۰�ü) stmt�� ������1 - sql���� ���鶧 �����ش�
//			stmt = conn.createStatement(); - sql���� �����Ҷ� ������ش�
			// ������2 : ����ǥ�� ä���ִ� �۾�!
			pstmt.setInt(1,  deptno); // sql�� ù��° ����ǥ�� int���� deptnt�� setting ���ش� ��
			pstmt.setString(2, dname); // �ι�° ����ǥ�� String�� dname ����
			pstmt.setString(3, loc);
			
			int result = pstmt.executeUpdate(); // sql�� ���� /����ǥ�� �ϳ��� �Է����� ��� �����߻�
//			int result = stmt.excuteUpdate(sql);
			
			System.out.println(result>0 ? deptno + " �� �μ� �Է� ����" : "�Է� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		
		
		
		
		
	}

}
