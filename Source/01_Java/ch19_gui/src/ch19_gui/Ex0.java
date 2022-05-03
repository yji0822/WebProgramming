package ch19_gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex0 {
	
	public static void main(String[] args) {
		
		Frame frame = new Frame("자바 첫 GUI"); // frame의 레이아웃 타입 ; BorderLayout
		Button btn = new Button("버튼");
		frame.add(btn, BorderLayout.NORTH); // 버튼을 NORTH쪽에 추가
		Button btn1 = new Button("그냥 버튼");
		frame.add(btn1, BorderLayout.CENTER); // 버튼을 CENTER에 추가
		
		// 화면에 출력
		frame.setSize(new Dimension(300, 200)); // 픽셀 사이즈 가로 300 세로 200
		frame.setVisible(true);
		frame.setLocation(100,50); // 창이 뜨는 위치
		// X 누르려면 콘솔의 정지버튼 클릭
		
		// 3초후 자동으로 창 닫고 실행 종료
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		frame.setVisible(false); // 화면(창)을 안보이게 함
		frame.dispose(); // 모든 자원들 해제
		System.exit(0); // 강제 종료
		
	}

}
