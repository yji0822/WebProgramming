package com.lec.ex2_person_dtoDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonMngGUI extends JFrame implements ActionListener {

	// ȭ�鿡 �� ������Ʈ
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> jnames;
	private JComboBox<String> comJob;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane; // 10�� ������ �ڵ����� ��ũ�� �����ǵ���

	// DB����
	private PersonDao dao = PersonDao.getinstance();
	private ArrayList<PersonDto> person;

	public PersonMngGUI(String title) { // Ÿ��Ʋ�� �ִ� ������
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X ������ ���� �Ǵ� ����

		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout()); // contenPane�� �⺻ ���̾ƿ��� BorderLayout
		jpup = new JPanel(new GridLayout(5, 2)); // Panel�� �⺻ ���̾ƿ��� FlowLayout
		jpbtn = new JPanel();

		txtName = new JTextField(20);
		jnames = dao.jnamelist(); // 0���� ����, 1���� ���... 2���� ����..
		comJob = new JComboBox<String>(jnames); // ������ list�� �޺��ڽ��� �����Ǵ� ��
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);

		// �̹��� ��ư - ���� �ٿ��ֱ� �� �̸� �����ؼ� ���
		ImageIcon icon1 = new ImageIcon("icon/join.png");
		btnInput = new JButton("�Է�", icon1);
		ImageIcon icon2 = new ImageIcon("icon/search.png");
		btnSearch = new JButton("������ȸ", icon2);
		ImageIcon icon3 = new ImageIcon("icon/output.png");
		btnOutput = new JButton("��ü���", icon3);
		ImageIcon icon4 = new ImageIcon("icon/exit.png");
		btnExit = new JButton("����", icon4);
		// ��ư ������ �����ϰ� �����ֱ�
		btnInput.setPreferredSize(new Dimension(150, 50));
		btnSearch.setPreferredSize(new Dimension(150, 50));
		btnOutput.setPreferredSize(new Dimension(150, 50));
		btnExit.setPreferredSize(new Dimension(150, 50));

		txtPool = new JTextArea(10, 60);
		scrollPane = new JScrollPane(txtPool); // ��ũ�� �ڵ����� ����
		// ������Ʈ ����
		// ������ ������Ʈ �߰�
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT)); // jpup : GridLayout
		jpup.add(txtName);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT)); // ����ȯ ��! ��ȣ ����
		jpup.add(comJob);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtMat);

		jpbtn.add(btnInput); // jpbtn : FlowLayout
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		contenPane.add(jpup); // contenPane : FlowLayout
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);

		setSize(new Dimension(700, 450));
		setLocation(200, 150); // ��� ��ġ ����
		setVisible(true);
		
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	} // ������ - PersonMngGUI

	// �̺�Ʈ ���� �߰�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInput) { 
			// txtName, comJob, txtKor, txtEng, txtMat�� ���� DB��
			String pname = txtName.getText().trim(); // �����̽� ����
			String jname = comJob.getSelectedItem().toString();
//			int jno = comJob.getSelectedIndex() * 10; // �ε����� �������� ��
			String korStr = txtKor.getText().trim();
			String engStr = txtEng.getText().trim();
			String matStr = txtMat.getText().trim();
			if(pname.equals("") || jname.equals("") 
					|| korStr.equals("") || engStr.equals("") || matStr.equals("")) {
				txtPool.setText("�̸�, ����, ��, ��, ���� ��� �Է� �ϼž� �Է� ����");
				return; // ���� Ÿ���� void�̱� ����.
			}
			// 1. ������ �Է�
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			
			PersonDto newPerson = new PersonDto(pname, jname, kor, eng, mat);
			int result = dao.insertPerson(newPerson);
			if(result == PersonDao.SUCCESS) {
				txtPool.setText(pname + "�� �Է� ����");
				txtName.setText("");
				comJob.setSelectedIndex(0); // �޺��ڽ��� 0��° ����
				comJob.setSelectedItem(""); // �޺��ڽ��� ""�� �ִ� ������ ����  // �� �Ʒ� �� �߿� �ϳ��� �����Ͽ� ���
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
			} // if
			
		} else if(e.getSource() == btnSearch) { 
			// 2. comJob�� ���õ� ������ȸ ����� txtPool
			String jname = comJob.getSelectedItem().toString();
			if(jname.equals("")) {
				txtPool.setText("���� ���� �� ������ȸ �ϼ���.");
				return;
			}
			person = dao.selectJname(jname);
			if(person.size() != 0) {
				txtPool.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
				for(PersonDto dto : person) {
					txtPool.append(dto.toString() + "\n"); // toString�� �ڵ����� �ٴ°� sysout! - append�� �߰��� ���ִ� ����
				} // for
			} else {
				txtPool.setText("�ش� �������� �ο��� �����ϴ�.");
			} // if-else
			
		} else if(e.getSource() == btnOutput) {
			// 3. ��ü ��ȸ ����� txtPool�� 
			person = dao.selectAll();
			if(person.size() != 0) {
				txtPool.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
				for(PersonDto dto : person) {
					txtPool.append(dto.toString() + "\n");
				} // for
			} else {
				txtPool.setText("��� ������ �������� �ʽ��ϴ�.");
			}
			
		} else if(e.getSource() == btnExit) {
			setVisible(false); // ȭ�� ������ ��
			dispose(); // �����ð��� ������ ���������� ����
			System.exit(0);
		}

	} // actionPerformed

	
	// main
	public static void main(String[] args) {
		new PersonMngGUI("������ ��������");
	} // main

} // Ŭ����
