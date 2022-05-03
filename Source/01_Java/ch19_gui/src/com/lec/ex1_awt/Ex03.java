package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex03 extends Frame implements ActionListener {

	private Panel panel;
	private TextField txtField;
	private Button btnOk, btnExit;
	private List list;

	// ������
	public Ex03() { // layout����, ������Ʈ ���� �� add, setVisible, setSize
//		setLayout(new BorderLayout()); Frame �⺻ ���̾ƿ��̹Ƿ� ���� ����
		// ������Ʈ ��ü ���� �Ϸ�
		panel = new Panel(); // panel�⺻ ���̾ƿ� new FlowLayout
		txtField = new TextField(20); // �ؽ�Ʈ ������ ����
		btnOk = new Button("OK");
		btnExit = new Button("Exit");
		list = new List();
		// �ۿ��� �̺�Ʈ�� �ɱ� ������ �ݵ�� ���� ������ Ŭ���� �����ٰ� ���ش�.
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);

		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);

		setVisible(true);
		setSize(new Dimension(400, 150));
		setLocation(200, 150);
		// X ��ư Ŭ�� ��, â ����
		addWindowListener(new WindowAdapter() { // new WindowAdapter() - �߻�Ŭ����
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // �Ⱥ��̰� ���ִ� ��
				dispose();         // �ڿ�����
				System.exit(0);    // ���� ����
			}
		}); // addWindowLietener
//		 �̺�Ʈ �߰� 1) implements ActionListner -> �������̵� �߰�(ctrl+1)
//		        2) �̺�Ʈ ������ �߰�(V) **** ����� ����! ***
		btnOk.addActionListener(this);
		btnExit.addActionListener(this); // this �ȿ� �ִ� actionPerformed �Լ� �ڵ����� ȣ��
//		        3) �������̵��� �Լ��� ���� �߰�.
	}
	public Ex03(String title) {
		this();
		setTitle(title);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		if(e.getSource() == btnOk) { // OK��ư Ŭ���� ������ ���� 
			// txtField�� �ؽ�Ʈ�� list�� �߰� - ������ string���� ���ͼ� parseint ���־�� �Ѵ�.
			list.add(txtField.getText().trim().toUpperCase()); // trim - �����̽� �����ֱ� / �빮�ڷ� ����
			txtField.setText(""); // �Է��� �ް� �ؽ�Ʈ �����ִ� ��
		} else if(e.getSource() == btnExit) {
			setVisible(false); // �Ⱥ��̰� ���ִ� ��
			dispose();         // �ڿ�����
			System.exit(0);    // ���� ����
		}
		
	}
	
	
	// MAIN
	public static void main(String[] args) {
		new Ex03();
		// new Ex03("LOGIN");
	}



}
