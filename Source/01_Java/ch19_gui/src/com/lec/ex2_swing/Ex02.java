package com.lec.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex02 extends JFrame implements ActionListener {

	// �ʿ��� ������Ʈ ���� �߰� - private
//	private JPanel jpanel; // �����̳� �޾ƿ���
	private Container         contenPane; // �����̳� ���� ����
	// Label�� �ܺ� ������ ���� ���ص� �ȴ�
	private ImageIcon         icon; // ��ư�� �� icon �̹���
	private JButton           jBtn; // icon�̶� ���� �ִ� ��ư
	private JTextField        jtxtField;
	private Vector<String>    items; // �޺��ڽ��� �� item����Ʈ (item�� �������϶��� Vector ����Ѵ�)
	private String[] item = {"A", "B", "C"};
	private JComboBox<String> jCombo;
	private JCheckBox         jCheck;
	private JLabel            jlBlank; // �� �� - �ؽ�Ʈ �ڽ��� �Էµ� ���� ����ϴ� �뵵
	private JButton           jBtnExit;
	
	// ������ : �����̳� ���ͼ� layout ���� => ������Ʈ ���� �� add => setVisible, setSize (ȭ�鱸��) => �̺�Ʈ �߰� 
	public Ex02() {
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X ��ư ������ ���� ����
		contenPane = getContentPane(); // swing�� �����̳ʸ� ���� �� �۾�
		contenPane.setLayout(new FlowLayout()); // ���̾ƿ� ���� - default north
		icon       = new ImageIcon("icon/write.gif");
		jBtn       = new JButton("Button", icon);
		jtxtField  = new JTextField();
//		jCombo = new JComboBox<String>(item); // �޺��ڽ� item ����Ʈ �߰� ��� 1. String �迭(������ ����Ʈ)
		items      = new Vector<String>();
		
		// items �߰��� ���׵� ��������
		items.add("A"); 
		items.add("B");
		items.add("C");
		jCombo   = new JComboBox<String>(items); // �޺��ڽ� item����Ʈ �߰���� 2. Vector �̿� (������)
		jCheck   = new JCheckBox("CheckBox");
		jlBlank  = new JLabel("");
		jBtnExit = new JButton("EXIT");
		
		// ������Ʈ add > ������Ʈ ������ ����(������pdf ����)
		contenPane.add(new JLabel("Label"));
		contenPane.add(jBtn);
		contenPane.add(jtxtField);
		contenPane.add(jCombo);
		contenPane.add(jCheck);
		contenPane.add(jlBlank);
		contenPane.add(jBtnExit); // add
		jBtn.setPreferredSize(new Dimension(200, 50));
		jtxtField.setPreferredSize(new Dimension(300, 50));
		jCombo.setPreferredSize(new Dimension(100, 50));
		jCheck.setPreferredSize(new Dimension(100, 50));
		jlBlank.setPreferredSize(new Dimension(200, 50));
		jBtnExit.setPreferredSize(new Dimension(100, 50)); // size
		// setVisible, setSize
		setVisible(true);
		pack(); // ������Ʈ���� ������ �ּ����� ������� â ũ�� ������ ����
		setLocation(100, 50);
		// �̺�Ʈ �� 4�� eventListener
		jBtn.addActionListener(this); // �ڵ������� ȣ��
		jCombo.addActionListener(this);
		jCheck.addActionListener(this);
		jBtnExit.addActionListener(this);
	}
	
	// �޼ҵ�
	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈ ����
		// �̺�Ʈ�� ����ȴٸ�
		if(e.getSource() == jBtn) {
			String temp = jtxtField.getText().trim().toUpperCase(); // �Է��� ���̸� ���� �����ϰ� �빮�ڷ�
			if(temp.equals("")) {
				System.out.println("����"); // jtxtField�� ��Ʈ���̰ų�  space�� �Է����� ���
				return;
			}
			jCombo.addItem(temp); // �޺��ڽ��� item �߰� (items ���Ϳ� �߰��� ����)
			jlBlank.setText(jtxtField.getText().trim()); // jlBlank���� jtxtField �Է� ���� �״��
			jtxtField.setText(""); // �Է��ϰ� ����
		} else if(e.getSource() == jCombo) {
			String temp = jCombo.getSelectedItem().toString(); // �޺��ڽ� ���õ� �׸�... ("A",,, "B"....
			int    no   = jCombo.getSelectedIndex();
			jlBlank.setText(no + "��° " + temp + "����"); // �޺��ڽ� �ȿ� �� �ִ°� �����ϸ� ���° ���� ��µƴ��� Ȯ��
			jCombo.setSelectedItem("A"); // "A"�� ���õǵ��� jCombo.setSeltedIndex(0);
		} else if(e.getSource() == jCheck) {
			if(jCheck.isSelected()) {
				// üũ�ڽ� üũ ��
				jlBlank.setText(jCheck.getText()); // üũ�ϸ� �ؽ�Ʈ ��� ���ְ�
			} else {
				jlBlank.setText(""); // ��üũ �Ǹ� �ؽ�Ʈ �����ִ� ��
			} // if-else 
		} else if(e.getSource() == jBtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	} // actionPerformed

	// Main
	public static void main(String[] args) {
		new Ex02(); // ����
	} // main
		
}
