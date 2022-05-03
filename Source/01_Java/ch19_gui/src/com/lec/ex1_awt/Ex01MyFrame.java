package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;


public class Ex01MyFrame extends Frame{
	
	private Button btn;
	private Button btn1;
	
	public Ex01MyFrame(String title) {
		super(title);
		btn = new Button("��ư");
		btn1 = new Button("�׳� ��ư");
		add(btn, BorderLayout.NORTH);
		add(btn1, BorderLayout.CENTER);
		setSize(new Dimension(300,500));
//		pack(); // ��ư�� �� �ּ����� ������� ������ش�.
		setVisible(true);
		setLocation(100,50);
		
		// 3���� �ڵ����� â �ݰ� ���� ����
		try {
			Thread.sleep(3000);
			} catch (InterruptedException e) {}
		setVisible(false); // ȭ��(â)�� �Ⱥ��̰� ��
		dispose(); // ��� �ڿ��� ����
		System.exit(0); // ���� ����
	
	} // Frame
	
	public static void main(String[] args) {
		new Ex01MyFrame("first GUI");
	}

}
