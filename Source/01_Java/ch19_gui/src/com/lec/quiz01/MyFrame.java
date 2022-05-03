package com.lec.quiz01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {

	// ������
	private Container  contenPane;
	private JPanel     jp1, jp2;
	private JTextField txtName, txtTel, txtAge; // �̸� ��ȭ��ȣ ����
	private ImageIcon  iconInput, iconOutput;
	private JButton    btnIn, btnOut;
	
	private ArrayList<Person> persons = new ArrayList<Person>();
	private OutputStream      os = null;
	
	// ������
	public MyFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		contenPane = getContentPane();
		jp1         = new JPanel();
		jp2         = new JPanel();
		jp1.setLayout(new GridLayout(3, 2));
		jp2.setLayout(new FlowLayout());
		
		txtName    = new JTextField();
		txtTel     = new JTextField();
		txtAge     = new JTextField();
		iconInput  = new ImageIcon("icon/join.png");
		iconOutput = new ImageIcon("icon/output.png");
		btnIn      = new JButton("�Է�", iconInput);
		btnOut     = new JButton("���", iconOutput);
		
		jp1.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jp1.add(txtName);
		jp1.add(new JLabel("��ȭ", (int) CENTER_ALIGNMENT));
		jp1.add(txtTel);
		jp1.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jp1.add(txtAge);
		
		jp2.add(btnIn);
		jp2.add(btnOut);
		
		// �����̳ʿ� Add
		contenPane.add(jp1, BorderLayout.CENTER);
		contenPane.add(jp2,BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(new Dimension(300,200));
		setLocation(200,50);
		
		btnIn.addActionListener(this);
		btnOut.addActionListener(this);
		
	}

	// �̺�Ʈ �߰��ϴ� �Լ�
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnIn) {
			String name = txtName.getText().trim();
			String tel = txtTel.getText().trim();
			int    age = 0;
			if(name.equals("") || tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �� �� �� �� �� �� �Դϴ�.");
				return;
			} 
			if(tel.indexOf("-") == tel.lastIndexOf("-")
					|| tel.indexOf("-") < 2 || tel.lastIndexOf("-") > 10) { // 010-9999-9999   010-1234(X)   123456789(X) �ϱ� ����
				System.out.println("��ȭ��ȣ ������ Ȯ���� �ּ���.");
				return;
			} // if - �Ǵ� ���ĵ��� ��ġ�� ������ ���� �� �ִ�.
			try {	
				age = Integer.parseInt(txtAge.getText());
				if(age < 0 || age > 150) {
					System.out.println("����. ��ȿ���� ���� ���� �Է�. �⺻�� 0�� ���");
					age = 0;
				}
			} catch (Exception e1){
				System.out.println("����. ��ȿ���� ���� ���̸� �Է��ϼ̽��ϴ�. �⺻�� 0���� ��µ˴ϴ�.");
			}
			
			// add
			persons.add(new Person(name, tel, age));
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText(""); // �Է��ϰ� ��ư ������ �������� �ʱ�ȭ
	
			
			
		} else if(e.getSource() == btnOut) {
			try {
				os = new FileOutputStream("src/com/lec/quiz01/person.txt");
				for(Person p : persons) {
					System.out.print(p);
					os.write(p.toString().getBytes());
				}
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if(os != null) {
						os.close();
					}
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			} // finally
		} // else if
	}

	// Main
	public static void main(String[] args) {
		new MyFrame("0408 GUI ����");
	}

}
