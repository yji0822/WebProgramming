package com.lec.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex02 extends JFrame implements ActionListener {

	// 필요한 컴포넌트 변수 추가 - private
//	private JPanel jpanel; // 컨테이너 받아오기
	private Container         contenPane; // 컨테이너 얻어올 변수
	// Label은 외부 변수에 선언 안해도 된다
	private ImageIcon         icon; // 버튼에 들어갈 icon 이미지
	private JButton           jBtn; // icon이랑 같이 있는 버튼
	private JTextField        jtxtField;
	private Vector<String>    items; // 콤보박스에 들어갈 item리스트 (item이 가변적일때는 Vector 사용한다)
	private String[] item = {"A", "B", "C"};
	private JComboBox<String> jCombo;
	private JCheckBox         jCheck;
	private JLabel            jlBlank; // 빈 라벨 - 텍스트 박스에 입력된 것을 출력하는 용도
	private JButton           jBtnExit;
	
	// 생성자 : 컨테이너 얻어와서 layout 세팅 => 컴포넌트 생성 후 add => setVisible, setSize (화면구현) => 이벤트 추가 
	public Ex02() {
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X 버튼 누르면 실행 종료
		contenPane = getContentPane(); // swing은 컨테이너를 얻어온 후 작업
		contenPane.setLayout(new FlowLayout()); // 레이아웃 지정 - default north
		icon       = new ImageIcon("icon/write.gif");
		jBtn       = new JButton("Button", icon);
		jtxtField  = new JTextField();
//		jCombo = new JComboBox<String>(item); // 콤보박스 item 리스트 추가 방법 1. String 배열(고정된 리스트)
		items      = new Vector<String>();
		
		// items 추가할 사항들 가져오기
		items.add("A"); 
		items.add("B");
		items.add("C");
		jCombo   = new JComboBox<String>(items); // 콤보박스 item리스트 추가방법 2. Vector 이용 (가변적)
		jCheck   = new JCheckBox("CheckBox");
		jlBlank  = new JLabel("");
		jBtnExit = new JButton("EXIT");
		
		// 컴포넌트 add > 컴포넌트 사이즈 조정(사이즈pdf 참조)
		contenPane.add(new JLabel("Label"));
		contenPane.add(jBtn);
		contenPane.add(jtxtField);
		contenPane.add(jCombo);
		contenPane.add(jCheck);
		contenPane.add(jlBlank);
		contenPane.add(jBtnExit); // add
		jBtn.setPreferredSize(new Dimension(200, 50));
		jtxtField.setPreferredSize(new Dimension(300, 50));
		jCombo.setPreferredSize(new Dimension(100, 50));
		jCheck.setPreferredSize(new Dimension(100, 50));
		jlBlank.setPreferredSize(new Dimension(200, 50));
		jBtnExit.setPreferredSize(new Dimension(100, 50)); // size
		// setVisible, setSize
		setVisible(true);
		pack(); // 컴포넌트들을 포함한 최소한의 사이즈로 창 크기 사이즈 조절
		setLocation(100, 50);
		// 이벤트 총 4개 eventListener
		jBtn.addActionListener(this); // 자동적으로 호출
		jCombo.addActionListener(this);
		jCheck.addActionListener(this);
		jBtnExit.addActionListener(this);
	}
	
	// 메소드
	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 로직
		// 이벤트가 실행된다면
		if(e.getSource() == jBtn) {
			String temp = jtxtField.getText().trim().toUpperCase(); // 입력한 아이를 띄어쓰기 제거하고 대문자로
			if(temp.equals("")) {
				System.out.println("떼끼"); // jtxtField에 빈스트링이거나  space만 입력했을 경우
				return;
			}
			jCombo.addItem(temp); // 콤보박스에 item 추가 (items 벡터에 추가도 가능)
			jlBlank.setText(jtxtField.getText().trim()); // jlBlank에는 jtxtField 입력 내용 그대로
			jtxtField.setText(""); // 입력하고 비우기
		} else if(e.getSource() == jCombo) {
			String temp = jCombo.getSelectedItem().toString(); // 콤보박스 선택된 항목... ("A",,, "B"....
			int    no   = jCombo.getSelectedIndex();
			jlBlank.setText(no + "번째 " + temp + "선택"); // 콤보박스 안에 들어가 있는거 선택하면 몇번째 것이 출력됐는지 확인
			jCombo.setSelectedItem("A"); // "A"가 선택되도록 jCombo.setSeltedIndex(0);
		} else if(e.getSource() == jCheck) {
			if(jCheck.isSelected()) {
				// 체크박스 체크 됨
				jlBlank.setText(jCheck.getText()); // 체크하면 텍스트 출력 해주고
			} else {
				jlBlank.setText(""); // 언체크 되면 텍스트 지워주는 것
			} // if-else 
		} else if(e.getSource() == jBtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	} // actionPerformed

	// Main
	public static void main(String[] args) {
		new Ex02(); // 실행
	} // main
		
}
