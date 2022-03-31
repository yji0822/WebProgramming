package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex1_string.Ex08_Friend;

public class Ex06_FreindsimpleDateFormat {

	public static void main(String[] args) {

		Ex08_Friend[] friends = { new Ex08_Friend("홍길동", "010-9999-9999", "03-28"),
		       					new Ex08_Friend("신길동", "010-8888-8888", "09-28"),
				    			new Ex08_Friend("마길동", "010-8888-9999", "05-28"),
					    		new Ex08_Friend("윤길동", "010-7777-7777", "04-28"),
						    	new Ex08_Friend("김길동", "010-9999-9999", "03-28") };
		/* 사용자로부터 검색할 전화번호  뒷자리를 입력받아 => 시스템으로부터 현재 날짜를 받아 "MM-dd" 스타일의 string으로 변환
		 * 0~끝방까지 해당전화번호가 있으면 출력		  => 0~끝방까지 해당 생일과 위에서 변환한 스트링 "03-28" 같으면 출력
		 * 검색이 되지 않아 출력 못하면 없는데! 라고 출력  => 해당 생일자가 없어 출력을 못하면 없는데! 출력
		 */
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd"); //MM-dd스타일로 형변환
		String todayStr = sdf.format(today);
		System.out.println(todayStr); // String으로 변환
		
		boolean searchOk = false; // 오늘자 생일인 친구가 있는지 확인. 찾으면 true로 바뀌는 걸로
		for(Ex08_Friend friend : friends) {
			String birthday = friend.getBirthday(); // 해당번째의 객체 생일값 get
			if(birthday.equals(todayStr)){
				System.out.println(friend);
				searchOk = true;
			} // if- 생일자이면 출력
		} // for
		if(!searchOk) {
			System.out.println("오늘 생일자인 친구는 없습니다.");
		}
		
	}

}
