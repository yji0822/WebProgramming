package com.lec.ex2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex04_GUI extends JFrame implements ActionListener {
	
	// ������Ʈ ��ü ���� ����, ((ArrayList����, file io�� ���� stream, db���� ���� ����))
	// �ؽ�Ʈ �ʵ�� ��� ��ư �Ʒ��� ����� �ؽ�Ʈ �ʵ�
	private Container  contenPane; // �����̳� �޾ƿ� ����
	private JPanel     jp;      // �̸�, ��ȭ, ���̹��� 6�� ������Ʈ�� gridLayout���� add
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon  icon;       // �̹����� ������ �����ڳ� �������.
	private JButton    btnOut;
	private JTextArea  jta;
	private JScrollPane scrollbar; // ��ũ�ѹ�
	private int         cnt;       // ��� �Է��ߴ��� ����
//	private ArrayList<Person> person; // ArrayList ���� �޼ҵ�
//	private OutputStriam os; // ��� �޼ҵ�
	
	// ������ : �����̳� ���ͼ� -> layout setting -> ������Ʈ ��ü ������ �� add(�����̳ʿ�!) -> �̺�Ʈ �߰�
	public Ex04_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
//		contenPane.setLayout(new BorderLayout()); // �⺻ ���̾ƿ��̱� ������ ���� ����
//		jp    = new JPanel();
//		jp.setLayout(new GridLayout(3, 2)); // �г��� �⺻ ���̾ƿ��� FlowLayout()�� 
		jp         = new JPanel(new GridLayout(3,2)); // �� �� ���̶� ���� ��
		txtName    = new JTextField(); // ������ �����ָ� �ڵ����� ���� Ȯ�� ��
		txtTel     = new JTextField();
		txtAge     = new JTextField();
		icon       = new ImageIcon("icon/output.png");
		btnOut     = new JButton("���", icon);
		jta        = new JTextArea(5, 30); // 5�� 30�� �� �� �ִ� text���� ���� (�Է� or ��� ����)
		scrollbar  = new JScrollPane(jta); // txt�� ��ũ�ѹ� ���� �� �ֵ���
		
		jp.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT)); // ���� �����̳� ��Ÿ ��� �ҁ� ��� ���� ���� �Ȼ�
		jp.add(txtName);
		jp.add(new JLabel("��  ȭ", (int) CENTER_ALIGNMENT));
		jp.add(txtTel);
		jp.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT));
		jp.add(txtAge);
		// �����̳ʿ� Add
		contenPane.add(jp, BorderLayout.NORTH);
		contenPane.add(btnOut, BorderLayout.CENTER);
		contenPane.add(scrollbar, BorderLayout.SOUTH); // ��ũ�ѹٰ� �ؽ�Ʈ �ʵ带 ǰ�� �־ ���� �����־�� �Ѵ�.
		setVisible(true);
//		setSize(new Dimension(400, 300));
//		setLocation(200, 100);
		setBounds(200, 100, 400, 300);
		// �̺�Ʈ �߰�
		// ��ư�� ������ ����ϴ� �̺�Ʈ
		btnOut.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈ �߰� > �̺�Ʈ ���� �ִ� �Լ�
		if(e.getSource() == btnOut) { // �̺�Ʈ �ɱ� ���Ѱ� btnout ����
			// ��ȿ�� ����! ��ȭ��ȣ�� ���Ŀ� �°� �Է��ߴ���, ���̸� ���ڷ� ����� �Է��� �ߴ���
			// txtname, txtTel, txtAge�� �Էµ� ���� jta�� ���
			String name = txtName.getText().trim(); // �Է��� ���� �ִ� ����.���� ���� 
			String tel  = txtTel.getText().trim();
			if(name.equals("") || tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �� �� �� �� �� �� �Դϴ�.");
				return;
			} // if - �������� �Է��ϸ� ���� �޼��� ���
			
			if(tel.indexOf("-") == tel.lastIndexOf("-")
					|| tel.indexOf("-") < 2 || tel.lastIndexOf("-") > 10) { // 010-9999-9999   010-1234(X)   123456789(X) �ϱ� ����
				System.out.println("��ȭ��ȣ ������ Ȯ���� �ּ���.");
				return;
			} // if - �Ǵ� ���ĵ��� ��ġ�� ������ ���� �� �ִ�.
			
			// ���� üũ 0~150������
			int age = 0;
			try {	
				age = Integer.parseInt(txtAge.getText());
				if(age < 0 || age > 150) {
					System.out.println("����. ��ȿ���� ���� ���� �Է�. �⺻�� 0�� ���");
					age = 0;
				}
			} catch (Exception e1){
				System.out.println("����. ��ȿ���� ���� ���̸� �Է��ϼ̽��ϴ�. �⺻�� 0���� ��µ˴ϴ�.");
			}
			System.out.println(++cnt + "�� �Է� ��");
			
			// ���
			if(cnt == 1) {
				jta.setText("�̸�\t��ȭ\t\t����\n");
			}
			jta.append(name + "\t" + tel + "\t\t" + age + "\n"); // �Ѹ� add�� ���� jta���
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText(""); // �Է��ϰ� ��ư ������ �������� �ʱ�ȭ
		} 
	} // actionPerformed

	// Main
	public static void main(String[] args) {
		new Ex04_GUI("last Ex");
	}

}
