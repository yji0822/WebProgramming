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

	// 화면에 들어갈 컴포넌트
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> jnames;
	private JComboBox<String> comJob;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane; // 10줄 넘으면 자동으로 스크롤 생성되도록

	// DB관련
	private PersonDao dao = PersonDao.getinstance();
	private ArrayList<PersonDto> person;

	public PersonMngGUI(String title) { // 타이틀이 있는 생성자
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X 누르면 종료 되는 로직

		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout()); // contenPane의 기본 레이아웃은 BorderLayout
		jpup = new JPanel(new GridLayout(5, 2)); // Panel의 기본 레이아웃은 FlowLayout
		jpbtn = new JPanel();

		txtName = new JTextField(20);
		jnames = dao.jnamelist(); // 0번은 공란, 1번은 배우... 2번은 가수..
		comJob = new JComboBox<String>(jnames); // 직업명 list가 콤보박스에 나열되는 것
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);

		// 이미지 버튼 - 복사 붙여넣기 후 이름 변경해서 사용
		ImageIcon icon1 = new ImageIcon("icon/join.png");
		btnInput = new JButton("입력", icon1);
		ImageIcon icon2 = new ImageIcon("icon/search.png");
		btnSearch = new JButton("직업조회", icon2);
		ImageIcon icon3 = new ImageIcon("icon/output.png");
		btnOutput = new JButton("전체출력", icon3);
		ImageIcon icon4 = new ImageIcon("icon/exit.png");
		btnExit = new JButton("종료", icon4);
		// 버튼 사이즈 동일하게 맞춰주기
		btnInput.setPreferredSize(new Dimension(150, 50));
		btnSearch.setPreferredSize(new Dimension(150, 50));
		btnOutput.setPreferredSize(new Dimension(150, 50));
		btnExit.setPreferredSize(new Dimension(150, 50));

		txtPool = new JTextArea(10, 60);
		scrollPane = new JScrollPane(txtPool); // 스크롤 자동으로 생성
		// 컴포넌트 생성
		// 생성된 컴포넌트 추가
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT)); // jpup : GridLayout
		jpup.add(txtName);
		jpup.add(new JLabel("직업", (int) CENTER_ALIGNMENT)); // 형변환 꼭! 괄호 주의
		jpup.add(comJob);
		jpup.add(new JLabel("국어", (int) CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("영어", (int) CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("수학", (int) CENTER_ALIGNMENT));
		jpup.add(txtMat);

		jpbtn.add(btnInput); // jpbtn : FlowLayout
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		contenPane.add(jpup); // contenPane : FlowLayout
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);

		setSize(new Dimension(700, 450));
		setLocation(200, 150); // 출력 위치 수정
		setVisible(true);
		
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	} // 생성자 - PersonMngGUI

	// 이벤트 로직 추가
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInput) { 
			// txtName, comJob, txtKor, txtEng, txtMat의 값을 DB로
			String pname = txtName.getText().trim(); // 스페이스 제거
			String jname = comJob.getSelectedItem().toString();
//			int jno = comJob.getSelectedIndex() * 10; // 인덱스를 가져오는 것
			String korStr = txtKor.getText().trim();
			String engStr = txtEng.getText().trim();
			String matStr = txtMat.getText().trim();
			if(pname.equals("") || jname.equals("") 
					|| korStr.equals("") || engStr.equals("") || matStr.equals("")) {
				txtPool.setText("이름, 직업, 국, 영, 수를 모두 입력 하셔야 입력 가능");
				return; // 리턴 타입이 void이기 때문.
			}
			// 1. 데이터 입력
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			
			PersonDto newPerson = new PersonDto(pname, jname, kor, eng, mat);
			int result = dao.insertPerson(newPerson);
			if(result == PersonDao.SUCCESS) {
				txtPool.setText(pname + "님 입력 성공");
				txtName.setText("");
				comJob.setSelectedIndex(0); // 콤보박스를 0번째 선택
				comJob.setSelectedItem(""); // 콤보박스를 ""이 있는 것으로 선택  // 위 아래 둘 중에 하나만 선택하여 사용
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
			} // if
			
		} else if(e.getSource() == btnSearch) { 
			// 2. comJob에 선택된 직업조회 결과를 txtPool
			String jname = comJob.getSelectedItem().toString();
			if(jname.equals("")) {
				txtPool.setText("직업 선택 후 직업조회 하세요.");
				return;
			}
			person = dao.selectJname(jname);
			if(person.size() != 0) {
				txtPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
				for(PersonDto dto : person) {
					txtPool.append(dto.toString() + "\n"); // toString이 자동으로 붙는건 sysout! - append는 추가를 해주는 로직
				} // for
			} else {
				txtPool.setText("해당 직업군의 인원이 없습니다.");
			} // if-else
			
		} else if(e.getSource() == btnOutput) {
			// 3. 전체 조회 결과를 txtPool로 
			person = dao.selectAll();
			if(person.size() != 0) {
				txtPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
				for(PersonDto dto : person) {
					txtPool.append(dto.toString() + "\n");
				} // for
			} else {
				txtPool.setText("출력 정보가 존재하지 않습니다.");
			}
			
		} else if(e.getSource() == btnExit) {
			setVisible(false); // 화면 가리는 것
			dispose(); // 일정시간이 지나면 강제적으로 종료
			System.exit(0);
		}

	} // actionPerformed

	
	// main
	public static void main(String[] args) {
		new PersonMngGUI("연예인 성적관리");
	} // main

} // 클래스
