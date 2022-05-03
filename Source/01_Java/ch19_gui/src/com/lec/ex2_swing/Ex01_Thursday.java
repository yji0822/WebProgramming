package com.lec.ex2_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex01_Thursday extends JFrame implements ActionListener {

	private JLabel jlbl;
	private JPanel panel; // 받아온 컨테이너를 저장
//	private Container containerPane; // 받아온 컨테이너를 저장
	// 생성자 위에다가 컴포넌트 변수들 설정!
	private JButton jbtn;
	
	// 생성자 - 타이틀을 설정해주는
	public Ex01_Thursday(String title) { // 컨테이너 받아와서 컴포넌트 add
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X 버튼 클릭시 종료
		// 스윙은 컨테이너 얻어오기 (맨처음) > 프레임을 컨테이너에 넣어주기
		panel = (JPanel) getContentPane(); // 최종적으로  프레임을 얻어온다는 의미 - 습관적으로 써줘라!
		panel.setLayout(new FlowLayout());
		jlbl = new JLabel("즐거운 목요일!", (int)CENTER_ALIGNMENT); // 왼쪽부터 출력이 디폴트/형변환 해주고 가운데 정렬
		jbtn = new JButton("EXIT");
		
		// add 
		panel.add(jlbl);
		jlbl.setPreferredSize(new Dimension(150, 200)); // 라벨 사이즈 설정
		panel.add(jbtn);
		jbtn.setPreferredSize(new Dimension(200, 200)); // EXIT 버튼 사이즈 설정
		// 출력화면 설정
		setVisible(true);
		setSize(new Dimension(400, 250)); 
		setLocation(200, 50); // 출력화면 위치
		// 이벤트 리스너 추가 ****
		jbtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtn) {
			setVisible(false); // 화면 안보이게
			dispose();         // 자원해제
			System.exit(0);    // -1 비정상종료 0 강제 종료
		}
	}
	
	// MAIN
	public static void main(String[] args) {
		new Ex01_Thursday("Happy Friday");
	} 
	

}
