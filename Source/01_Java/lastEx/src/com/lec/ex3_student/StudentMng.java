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
		
		contenPane = getContentPane(); // 화면구현
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4,3));
		jpbtn = new JPanel(new FlowLayout()); // 기본이 flowlayout
		
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		mnames = dao.getMNamelist();
		comMname = new JComboBox<String>(mnames);
		txtScore = new JTextField(10);
		
		btnSNoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMNameSearch = new JButton("전공검색");
		
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpelOut = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		
		// 생성된 컴포넌트 추가
		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
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
	
	// 이벤트 로직 추가
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSNoSearch) { // 학번검색
			// txtSNo.getText() 를 받아 학번 검색하여 txtSName, comMname, txtScore에 넣어준다			
			txtSName.setText("");
			txtScore.setText("");
			comMname.setSelectedIndex(0);
			
			String sno = txtSNo.getText().trim();
			
			if(sno.length() == 0) {
				System.out.println("입력된 내용이 없습니다.");
				return;
			} 
			
			StudentDto dto = dao.sNogetStudent(sno); 
			if(dto != null) {
				txtSName.setText(dto.getsName());
				comMname.setSelectedItem(dto.getmName());
//				txtScore.setText("" + dto.getScore());
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText(sno + " 검색 완료");

			} else {
					txtPool.setText(sno + " / 입력하신 학번은 유효하지 않습니다.");
			} // if-else 
			
		} else if(e.getSource() == btnSNameSearch) { // 이름검색
			// txtSName.getText() 를 받아 이름 검색
			// arraylist size확인하여, 검색한 결과가 없는 경우, 한명인 경우, 두명이상 인경우 결과가 다르다 
			txtSNo.setText("");
			txtScore.setText("");
			comMname.setSelectedIndex(0);
			
			String sname = txtSName.getText().trim();
			
			if(sname.length() == 0) {
				txtPool.setText("이름이 입력되지 않았습니다.");
				return;
			}
			
			ArrayList<StudentDto> students = dao.sNamegetStudent(sname);
			
			if(students.size() == 0) {
				txtPool.setText("해당 이름의 학생은 존재하지 않습니다.");
			} else if(students.size() == 1) {
				txtSNo.setText(students.get(0).getsNo());
				txtSName.setText(students.get(0).getsName());
				comMname.setSelectedItem(students.get(0).getmName());
				txtScore.setText(String.valueOf(students.get(0).getScore()));
			} else if(students.size() > 1){
				txtPool.setText("학번 \t 이름 \t 학과명 \t 점수 \n");
				txtPool.append("---------------------------------------------------------------------------------------\n");
				for(StudentDto sd : students) {
					txtPool.append(sd.toString() + "\n");
				}
			}
			
		} else if(e.getSource() == btnMNameSearch) { // 전공검색
			// comMname 콤보박스에 선택된 전공이름으로 검색하여 출력
			txtSNo.setText("");
			txtSName.setText("");
			txtScore.setText("");
			
			String mname = comMname.getSelectedItem().toString();
			ArrayList<StudentDto> students = dao.mNamegetStudent(mname);
			
			if(mname.equals("")) {
				txtPool.setText("전공 선택 후 검색을 눌러주세요.");
				 return;
			} 
			
			if(!mname.isEmpty()) {
				txtPool.setText("등수 \t 이름 \t\t학과명 \t\t점수 \n");
				for(StudentDto sd : students) {
					txtPool.append(sd.toString() + "\n");
				}
			}
			
		} else if(e.getSource()==btnInput) { // 학생입력
			// txtSName, comMname, txtScore값을 받아 학생입력 
			// (txtScores에 유효한 점수를 입력하지 않을 경우 에러 메세지 출력)
			txtSNo.setText("");
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			int score = Integer.parseInt(txtScore.getText().trim());
			
			if(sname.equals("") || mname.equals("") || (score<0 || score>100)) {
				txtPool.setText("조건에 맞도록 점수를 입력해 주세요.");
			}
			
			StudentDto newStudent = new StudentDto(sname, mname, score);
			int result = dao.insertStudent(newStudent);
			
			if(result == StudentDao.SUCCESS) {
				txtPool.setText(sname + " 학생 입력 성공");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				comMname.setSelectedItem("");
				txtScore.setText("");
			} else {
				txtPool.setText("입력 오류");
			}
			
			
		} else if(e.getSource()==btnUpdate) { // 학생수정
		 	// txtSNo, txtSName, comMname, txtScore값을 받아 학생 수정
			String sno = txtSNo.getText().trim();
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			int score = Integer.parseInt(txtScore.getText().trim());
			
			if(sno.equals("") || sname.equals("") || mname.equals("") || (score<0 || score>100)) {
				txtPool.setText("형식에 맞는 값을 입력하여 주세요.");
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
				txtPool.setText("입력 실패");
			}
			
		} else if(e.getSource() == btnStudentOut) { // 학생출력
			// 제적되지 않는 학생들 pdf와 같이 출력
			students = dao.getStudents();
			if(students.size() != 0) {
				txtPool.setText("등수\t이름\t\t학과명\t\t점수\n");
				for(StudentDto sd : students) {
					txtPool.append(sd.toString() + "\n");
				}
			} else {
				txtPool.setText("출력정보가 없습니다.");
			}
			
		} else if(e.getSource() == btnExpelOut) { // 제적자출력
			// 제적된 학생들 pdf와 같이 출력
			students = dao.getStudentExpel();
			if(students.size() != 0) {
				txtPool.setText("등수\t이름\t\t학과명\t\t점수\n");
				for(StudentDto sd : students) {
					txtPool.append(sd.toString() + "\n");
					}
			}
			
		} else if(e.getSource() == btnExpel) { // 제적처리
			// txtSNo에 입력된 학생 제적처리 반드시 학번이 들어가야 함
			// 없는 학번이 입력되었으면 에러메세지 출력
			String sno = txtSNo.getText().trim();
			if(sno.length() == 0) {
				txtPool.setText("학번을 다시 확인해주세요.");
				return;
			}
			int result = dao.sNoExpel(sno);
			if(result == StudentDao.SUCCESS) {
				txtPool.setText(sno + "학생 제적 처리 완료");
			} else {
				txtPool.setText(sno + "학번은 유효하지 않으므로 제적처리 불가");
			}
			
		} else if(e.getSource() == btnExit) { // 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	// main
	public static void main(String[] args) {
		new StudentMng("학사관리");
	}


}
