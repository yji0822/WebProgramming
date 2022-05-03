package com.lec.ex2_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex01_Thursday extends JFrame implements ActionListener {

	private JLabel jlbl;
	private JPanel panel; // �޾ƿ� �����̳ʸ� ����
//	private Container containerPane; // �޾ƿ� �����̳ʸ� ����
	// ������ �����ٰ� ������Ʈ ������ ����!
	private JButton jbtn;
	
	// ������ - Ÿ��Ʋ�� �������ִ�
	public Ex01_Thursday(String title) { // �����̳� �޾ƿͼ� ������Ʈ add
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X ��ư Ŭ���� ����
		// ������ �����̳� ������ (��ó��) > �������� �����̳ʿ� �־��ֱ�
		panel = (JPanel) getContentPane(); // ����������  �������� ���´ٴ� �ǹ� - ���������� �����!
		panel.setLayout(new FlowLayout());
		jlbl = new JLabel("��ſ� �����!", (int)CENTER_ALIGNMENT); // ���ʺ��� ����� ����Ʈ/����ȯ ���ְ� ��� ����
		jbtn = new JButton("EXIT");
		
		// add 
		panel.add(jlbl);
		jlbl.setPreferredSize(new Dimension(150, 200)); // �� ������ ����
		panel.add(jbtn);
		jbtn.setPreferredSize(new Dimension(200, 200)); // EXIT ��ư ������ ����
		// ���ȭ�� ����
		setVisible(true);
		setSize(new Dimension(400, 250)); 
		setLocation(200, 50); // ���ȭ�� ��ġ
		// �̺�Ʈ ������ �߰� ****
		jbtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtn) {
			setVisible(false); // ȭ�� �Ⱥ��̰�
			dispose();         // �ڿ�����
			System.exit(0);    // -1 ���������� 0 ���� ����
		}
	}
	
	// MAIN
	public static void main(String[] args) {
		new Ex01_Thursday("Happy Friday");
	} 
	

}
