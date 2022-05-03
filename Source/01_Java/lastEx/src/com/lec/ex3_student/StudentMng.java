package com.lec.ex3_student;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentMng extends JFrame implements ActionListener {
	
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private Vector<String> mnames;
	private JComboBox<String> comMname;
	private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch;
	private JButton btnInput, btnUpdate, btnStudentOut, btnExpelOut, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	
	// db
	private StudentDao dao = StudentDao.getInstance();
	private ArrayList<StudentDto> students;
	
	
	public StudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contenPane = getContentPane(); // ȭ�鱸��
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4,3));
		jpbtn = new JPanel(new FlowLayout()); // �⺻�� flowlayout
		
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		mnames = dao.getMNamelist();
		comMname = new JComboBox<String>(mnames);
		txtScore = new JTextField(10);
		
		btnSNoSearch = new JButton("�й��˻�");
		btnSNameSearch = new JButton("�̸��˻�");
		btnMNameSearch = new JButton("�����˻�");
		
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		
		// ������ ������Ʈ �߰�
		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		jpup.add(new JLabel(""));
		
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		
		setSize(new Dimension(750,400));
		setLocation(200, 200);
		setVisible(true);
		
		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
		
	}
	
	// �̺�Ʈ ���� �߰�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSNoSearch) { // �й��˻�
			// txtSNo.getText() �� �޾� �й� �˻��Ͽ� txtSName, comMname, txtScore�� �־��ش�			
			txtSName.setText("");
			txtScore.setText("");
			comMname.setSelectedIndex(0);
			
			String sno = txtSNo.getText().trim();
			
			if(sno.length() == 0) {
				System.out.println("�Էµ� ������ �����ϴ�.");
				return;
			} 
			
			StudentDto dto = dao.sNogetStudent(sno); 
			if(dto != null) {
				txtSName.setText(dto.getsName());
				comMname.setSelectedItem(dto.getmName());
//				txtScore.setText("" + dto.getScore());
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText(sno + " �˻� �Ϸ�");

			} else {
					txtPool.setText(sno + " / �Է��Ͻ� �й��� ��ȿ���� �ʽ��ϴ�.");
			} // if-else 
			
		} else if(e.getSource() == btnSNameSearch) { // �̸��˻�
			// txtSName.getText() �� �޾� �̸� �˻�
			// arraylist sizeȮ���Ͽ�, �˻��� ����� ���� ���, �Ѹ��� ���, �θ��̻� �ΰ�� ����� �ٸ��� 
			txtSNo.setText("");
			txtScore.setText("");
			comMname.setSelectedIndex(0);
			
			String sname = txtSName.getText().trim();
			
			if(sname.length() == 0) {
				txtPool.setText("�̸��� �Էµ��� �ʾҽ��ϴ�.");
				return;
			}
			
			ArrayList<StudentDto> students = dao.sNamegetStudent(sname);
			
			if(students.size() == 0) {
				txtPool.setText("�ش� �̸��� �л��� �������� �ʽ��ϴ�.");
			} else if(students.size() == 1) {
				txtSNo.setText(students.get(0).getsNo());
				txtSName.setText(students.get(0).getsName());
				comMname.setSelectedItem(students.get(0).getmName());
				txtScore.setText(String.valueOf(students.get(0).getScore()));
			} else if(students.size() > 1){
				txtPool.setText("�й� \t �̸� \t �а��� \t ���� \n");
				txtPool.append("---------------------------------------------------------------------------------------\n");
				for(StudentDto sd : students) {
					txtPool.append(sd.toString() + "\n");
				}
			}
			
		} else if(e.getSource() == btnMNameSearch) { // �����˻�
			// comMname �޺��ڽ��� ���õ� �����̸����� �˻��Ͽ� ���
			txtSNo.setText("");
			txtSName.setText("");
			txtScore.setText("");
			
			String mname = comMname.getSelectedItem().toString();
			ArrayList<StudentDto> students = dao.mNamegetStudent(mname);
			
			if(mname.equals("")) {
				txtPool.setText("���� ���� �� �˻��� �����ּ���.");
				 return;
			} 
			
			if(!mname.isEmpty()) {
				txtPool.setText("��� \t �̸� \t\t�а��� \t\t���� \n");
				for(StudentDto sd : students) {
					txtPool.append(sd.toString() + "\n");
				}
			}
			
		} else if(e.getSource()==btnInput) { // �л��Է�
			// txtSName, comMname, txtScore���� �޾� �л��Է� 
			// (txtScores�� ��ȿ�� ������ �Է����� ���� ��� ���� �޼��� ���)
			txtSNo.setText("");
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			int score = Integer.parseInt(txtScore.getText().trim());
			
			if(sname.equals("") || mname.equals("") || (score<0 || score>100)) {
				txtPool.setText("���ǿ� �µ��� ������ �Է��� �ּ���.");
			}
			
			StudentDto newStudent = new StudentDto(sname, mname, score);
			int result = dao.insertStudent(newStudent);
			
			if(result == StudentDao.SUCCESS) {
				txtPool.setText(sname + " �л� �Է� ����");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				comMname.setSelectedItem("");
				txtScore.setText("");
			} else {
				txtPool.setText("�Է� ����");
			}
			
			
		} else if(e.getSource()==btnUpdate) { // �л�����
		 	// txtSNo, txtSName, comMname, txtScore���� �޾� �л� ����
			String sno = txtSNo.getText().trim();
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			int score = Integer.parseInt(txtScore.getText().trim());
			
			if(sno.equals("") || sname.equals("") || mname.equals("") || (score<0 || score>100)) {
				txtPool.setText("���Ŀ� �´� ���� �Է��Ͽ� �ּ���.");
			}
			StudentDto revStudent = new StudentDto(sno, sname, mname, score);
			int result = dao.updateStudent(revStudent);
			
			if(result == dao.SUCCESS) {
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				comMname.setSelectedItem("");
				txtScore.setText("");
			} else {
				txtPool.setText("�Է� ����");
			}
			
		} else if(e.getSource() == btnStudentOut) { // �л����
			// �������� �ʴ� �л��� pdf�� ���� ���
			students = dao.getStudents();
			if(students.size() != 0) {
				txtPool.setText("���\t�̸�\t\t�а���\t\t����\n");
				for(StudentDto sd : students) {
					txtPool.append(sd.toString() + "\n");
				}
			} else {
				txtPool.setText("��������� �����ϴ�.");
			}
			
		} else if(e.getSource() == btnExpelOut) { // ���������
			// ������ �л��� pdf�� ���� ���
			students = dao.getStudentExpel();
			if(students.size() != 0) {
				txtPool.setText("���\t�̸�\t\t�а���\t\t����\n");
				for(StudentDto sd : students) {
					txtPool.append(sd.toString() + "\n");
					}
			}
			
		} else if(e.getSource() == btnExpel) { // ����ó��
			// txtSNo�� �Էµ� �л� ����ó�� �ݵ�� �й��� ���� ��
			// ���� �й��� �ԷµǾ����� �����޼��� ���
			String sno = txtSNo.getText().trim();
			if(sno.length() == 0) {
				txtPool.setText("�й��� �ٽ� Ȯ�����ּ���.");
				return;
			}
			int result = dao.sNoExpel(sno);
			if(result == StudentDao.SUCCESS) {
				txtPool.setText(sno + "�л� ���� ó�� �Ϸ�");
			} else {
				txtPool.setText(sno + "�й��� ��ȿ���� �����Ƿ� ����ó�� �Ұ�");
			}
			
		} else if(e.getSource() == btnExit) { // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	// main
	public static void main(String[] args) {
		new StudentMng("�л����");
	}


}
