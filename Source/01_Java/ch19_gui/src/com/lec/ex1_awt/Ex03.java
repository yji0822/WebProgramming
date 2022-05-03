package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex03 extends Frame implements ActionListener {

	private Panel panel;
	private TextField txtField;
	private Button btnOk, btnExit;
	private List list;

	// 생성자
	public Ex03() { // layout세팅, 컴포넌트 생성 후 add, setVisible, setSize
//		setLayout(new BorderLayout()); Frame 기본 레이아웃이므로 생략 가능
		// 컴포넌트 객체 생성 완료
		panel = new Panel(); // panel기본 레이아웃 new FlowLayout
		txtField = new TextField(20); // 텍스트 사이즈 조절
		btnOk = new Button("OK");
		btnExit = new Button("Exit");
		list = new List();
		// 밖에서 이벤트를 걸기 때문에 반드시 변수 선언은 클래스 위에다가 해준다.
		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);

		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);

		setVisible(true);
		setSize(new Dimension(400, 150));
		setLocation(200, 150);
		// X 버튼 클릭 시, 창 종료
		addWindowListener(new WindowAdapter() { // new WindowAdapter() - 추상클래스
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // 안보이게 해주는 것
				dispose();         // 자원해제
				System.exit(0);    // 강제 종료
			}
		}); // addWindowLietener
//		 이벤트 추가 1) implements ActionListner -> 오버라이드 추가(ctrl+1)
//		        2) 이벤트 리스너 추가(V) **** 까먹지 말기! ***
		btnOk.addActionListener(this);
		btnExit.addActionListener(this); // this 안에 있는 actionPerformed 함수 자동으로 호출
//		        3) 오버라이드한 함수에 로직 추가.
	}
	public Ex03(String title) {
		this();
		setTitle(title);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		if(e.getSource() == btnOk) { // OK버튼 클릭시 실행할 로직 
			// txtField의 텍스트를 list에 추가 - 무조건 string으로 들어와서 parseint 해주어야 한다.
			list.add(txtField.getText().trim().toUpperCase()); // trim - 스페이스 지워주기 / 대문자로 변형
			txtField.setText(""); // 입력을 받고 텍스트 지워주는 것
		} else if(e.getSource() == btnExit) {
			setVisible(false); // 안보이게 해주는 것
			dispose();         // 자원해제
			System.exit(0);    // 강제 종료
		}
		
	}
	
	
	// MAIN
	public static void main(String[] args) {
		new Ex03();
		// new Ex03("LOGIN");
	}



}
