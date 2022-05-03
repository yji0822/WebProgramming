package com.lec.ex1_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02_login extends Frame {

	// 출력 순서대로 변수를 만들어준다. - 프레임 안에 들어갈 컴포넌트들
	private Label     lbl1; // 기본값 모두 null
	private TextField txtId;
	private Label     lbl2;
	private TextField txtPw;
	private Button    btnLogin;
	
	public Ex02_login(String title) { // 반드시 실행해야하는 생성자
	// Frame에 컴포넌트 추가하고 화면에 보이게 > 이벤트
		super(title); // 반드시 맨 첫번째 줄에
		// Frame의 레이아웃 타입 : BorderLayout (동서남북, 센터) 기본값. - 따로 지정을 안하면 출력하기 전에 지정
		//                   FlowLayout(왼쪽부터 오른쪽으로, 위부터 아래로 차곡차곡 컴포넌트가 add 되는 것)
		//                   GridLayout(몇행 몇열)
		setLayout(new FlowLayout()); // Frame의 레이아웃 세팅

		lbl1  = new Label("아이디    "); // 객체 생성
		txtId = new TextField("ID", 20); // 20~30글자 정도 받을 수 있는 텍스트 박스 생성
		lbl2  = new Label("비밀번호");
		txtPw = new TextField(20); // 보통은 숫자만 세팅
		txtPw.setEchoChar('*'); // 입력은 받지만 *로 받는다!
		btnLogin = new Button("LOGIN 로그인"); // 로그인 버튼
		
		// 순서대로 작성한 것을 NullpointException 주의하기
		add(lbl1);
		add(txtId);
		add(lbl2);
		add(txtPw);
		add(btnLogin);
		
		setSize(new Dimension(300 ,150)); // 창 사이즈 설정
		setLocation(200,100); // 창이 뜨는 위치 설정
		setVisible(true); // 창 뜰 수 있게 해주는 것
		setResizable(false); // resize 못하게 하는 것
		
		// X 버튼 클릭 시, 종료되는 것 설정
		addWindowListener(new WindowAdapter() { // new WindowAdapter() - 추상클래스
			// addWindowListener - 누르는지 안누르는지 계속 듣고 있겠다는 의미
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // 안보이게 해주는 것
				dispose(); //자원해제
				System.exit(0);
			}
		}); // addWindowLietener 
	}
	public Ex02_login() {
		this(""); // 위의 생성자를 실행하는 것
	}

	
	public static void main(String[] args) {

		new Ex02_login("Login"); // 출력
		
		
	}

}
