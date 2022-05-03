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
	
	// 컴포넌트 객체 변수 선언, ((ArrayList변수, file io를 위한 stream, db접속 관련 변수))
	// 텍스트 필드랑 출력 버튼 아래에 출력할 텍스트 필드
	private Container  contenPane; // 컨테이너 받아올 변수
	private JPanel     jp;      // 이름, 전화, 나이받을 6개 컴포넌트를 gridLayout으로 add
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon  icon;       // 이미지는 변수나 생성자나 상관없다.
	private JButton    btnOut;
	private JTextArea  jta;
	private JScrollPane scrollbar; // 스크롤바
	private int         cnt;       // 몇명 입력했는지 저장
//	private ArrayList<Person> person; // ArrayList 관련 메소드
//	private OutputStriam os; // 출력 메소드
	
	// 생성자 : 컨테이너 얻어와서 -> layout setting -> 컴포넌트 객체 생성한 후 add(컨테이너에!) -> 이벤트 추가
	public Ex04_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
//		contenPane.setLayout(new BorderLayout()); // 기본 레이아웃이기 때문에 생략 가능
//		jp    = new JPanel();
//		jp.setLayout(new GridLayout(3, 2)); // 패널의 기본 레이아웃은 FlowLayout()임 
		jp         = new JPanel(new GridLayout(3,2)); // 위 두 줄이랑 같은 말
		txtName    = new JTextField(); // 옆에서 정해주면 자동으로 공간 확보 됨
		txtTel     = new JTextField();
		txtAge     = new JTextField();
		icon       = new ImageIcon("icon/output.png");
		btnOut     = new JButton("출력", icon);
		jta        = new JTextArea(5, 30); // 5행 30열 쓸 수 있는 text공간 생성 (입력 or 출력 가능)
		scrollbar  = new JScrollPane(jta); // txt에 스크롤바 만들 수 있도록
		
		jp.add(new JLabel("이  름", (int) CENTER_ALIGNMENT)); // 높이 조절이나 기타 등등 할겍 없어서 변수 따로 안뺌
		jp.add(txtName);
		jp.add(new JLabel("전  화", (int) CENTER_ALIGNMENT));
		jp.add(txtTel);
		jp.add(new JLabel("나  이", (int) CENTER_ALIGNMENT));
		jp.add(txtAge);
		// 컨테이너에 Add
		contenPane.add(jp, BorderLayout.NORTH);
		contenPane.add(btnOut, BorderLayout.CENTER);
		contenPane.add(scrollbar, BorderLayout.SOUTH); // 스크롤바가 텍스트 필드를 품고 있어서 먼저 적어주어야 한다.
		setVisible(true);
//		setSize(new Dimension(400, 300));
//		setLocation(200, 100);
		setBounds(200, 100, 400, 300);
		// 이벤트 추가
		// 버튼을 누르면 출력하는 이벤트
		btnOut.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 추가 > 이벤트 로직 넣는 함수
		if(e.getSource() == btnOut) { // 이벤트 걸기 위한게 btnout 인지
			// 유효성 검증! 전화번호를 형식에 맞게 입력했는지, 나이를 숫자로 제대로 입력을 했는지
			// txtname, txtTel, txtAge에 입력된 것을 jta에 출력
			String name = txtName.getText().trim(); // 입력한 것을 넣는 로직.띄어쓰기 제거 
			String tel  = txtTel.getText().trim();
			if(name.equals("") || tel.equals("")) {
				System.out.println("이름과 전화번호는 필 수 입 력 사 항 입니다.");
				return;
			} // if - 공란으로 입력하면 오류 메세지 출력
			
			if(tel.indexOf("-") == tel.lastIndexOf("-")
					|| tel.indexOf("-") < 2 || tel.lastIndexOf("-") > 10) { // 010-9999-9999   010-1234(X)   123456789(X) 하기 나름
				System.out.println("전화번호 형식을 확인해 주세요.");
				return;
			} // if - 되는 형식들은 겹치기 때문에 꼬일 수 있다.
			
			// 나이 체크 0~150세까지
			int age = 0;
			try {	
				age = Integer.parseInt(txtAge.getText());
				if(age < 0 || age > 150) {
					System.out.println("오류. 유효하지 않은 나이 입력. 기본값 0살 출력");
					age = 0;
				}
			} catch (Exception e1){
				System.out.println("오류. 유효하지 않은 나이를 입력하셨습니다. 기본값 0으로 출력됩니다.");
			}
			System.out.println(++cnt + "명 입력 됨");
			
			// 출력
			if(cnt == 1) {
				jta.setText("이름\t전화\t\t나이\n");
			}
			jta.append(name + "\t" + tel + "\t\t" + age + "\n"); // 한명 add한 것을 jta출력
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText(""); // 입력하고 버튼 누르면 공백으로 초기화
		} 
	} // actionPerformed

	// Main
	public static void main(String[] args) {
		new Ex04_GUI("last Ex");
	}

}
