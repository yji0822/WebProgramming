package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02_login2 extends Frame {

	// ��� ������� ������ ������ش�. - ������ �ȿ� �� ������Ʈ��
	private Panel     panel;
	private Label     lbl1; // �⺻�� ��� null
	private TextField txtId;
	private Label     lbl2;
	private TextField txtPw;
	private Button    btnLogin;
	
	public Ex02_login2(String title) { // �ݵ�� �����ؾ��ϴ� ������
	// Frame�� ������Ʈ �߰��ϰ� ȭ�鿡 ���̰� > �̺�Ʈ
		super(title); // �ݵ�� �� ù��° �ٿ�
		// Frame�� ���̾ƿ� Ÿ�� : BorderLayout (��������, ����) �⺻��. - ���� ������ ���ϸ� ����ϱ� ���� ����(���� ���� ���ص���)
		//                   FlowLayout(���ʺ��� ����������, ������ �Ʒ��� �������� ������Ʈ�� add �Ǵ� ��)
		//                   GridLayout(���� �)
		panel = new Panel(); // �г��� �⺻ ���̾ƿ� : FlowLayout
//		setLayout(new GridLayout(2, 2)); �� ��� ���Ѵ�.
		lbl1  = new Label("���̵�    "); // ��ü ����
		txtId = new TextField("ID", 20); // 20~30���� ���� ���� �� �ִ� �ؽ�Ʈ �ڽ� ����
		lbl2  = new Label("��й�ȣ");
		txtPw = new TextField(20); // ������ ���ڸ� ����
		txtPw.setEchoChar('*'); // �Է��� ������ *�� �޴´�!
		btnLogin = new Button("LOGIN �α���"); // �α��� ��ư
		
		// ������� �ۼ��� ���� NullpointException �����ϱ�
		panel.add(lbl1);
		panel.add(txtId);
		panel.add(lbl2);
		panel.add(txtPw);
		panel.setPreferredSize(new Dimension(280, 50));
		
		add(panel, BorderLayout.NORTH);
		add(btnLogin, BorderLayout.SOUTH);
		
		setSize(new Dimension(300 ,150)); // â ������ ����
		setLocation(200,100); // â�� �ߴ� ��ġ ����
		setVisible(true); // â �� �� �ְ� ���ִ� ��
		setResizable(false); // resize ���ϰ� �ϴ� ��
		
		// X ��ư Ŭ�� ��, ����Ǵ� �� ����
		addWindowListener(new WindowAdapter() { // new WindowAdapter() - �߻�Ŭ����
			// addWindowListener - �������� �ȴ������� ��� ��� �ְڴٴ� �ǹ�
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // �Ⱥ��̰� ���ִ� ��
				dispose(); //�ڿ�����
				System.exit(0);
			}
		}); // addWindowLietener 
	}
	public Ex02_login2() {
		this(""); // ���� �����ڸ� �����ϴ� ��
	}

	
	public static void main(String[] args) {

		new Ex02_login2("Login"); // ���
		
	}

	
}
