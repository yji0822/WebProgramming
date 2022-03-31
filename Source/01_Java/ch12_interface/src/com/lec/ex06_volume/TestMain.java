package com.lec.ex06_volume;

public class TestMain {

	public static void main(String[] args) {
//		TV tv = new TV(3); // volume 3
		// 바뀌거나 추가한 것이 없기 때문에 
		IVolume[] volumes = { new TV(3), new Speaker(5), new TV(10), new Speaker(7) };
		for(IVolume temp : volumes) {
			temp.volumeDown();
			temp.volumeDown(20);
			temp.volumeUp(10);
			temp.volumeUp(45);
			temp.setMute(true); // default메소드
			System.out.println("===========================================");
			
		}
		
	}

}
