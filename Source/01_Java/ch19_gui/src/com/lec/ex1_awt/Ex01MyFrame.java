package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;


public class Ex01MyFrame extends Frame{
	
	private Button btn;
	private Button btn1;
	
	public Ex01MyFrame(String title) {
		super(title);
		btn = new Button("버튼");
		btn1 = new Button("그냥 버튼");
		add(btn, BorderLayout.NORTH);
		add(btn1, BorderLayout.CENTER);
		setSize(new Dimension(300,500));
//		pack(); // 버튼이 들어갈 최소한의 사이즈로 출력해준다.
		setVisible(true);
		setLocation(100,50);
		
		// 3초후 자동으로 창 닫고 실행 종료
		try {
			Thread.sleep(3000);
			} catch (InterruptedException e) {}
		setVisible(false); // 화면(창)을 안보이게 함
		dispose(); // 모든 자원들 해제
		System.exit(0); // 강제 종료
	
	} // Frame
	
	public static void main(String[] args) {
		new Ex01MyFrame("first GUI");
	}

}
