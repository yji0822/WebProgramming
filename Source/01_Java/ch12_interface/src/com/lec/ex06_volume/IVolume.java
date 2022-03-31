package com.lec.ex06_volume;

public interface IVolume { // 지침서
	public void volumeUp(); // 볼륨+1
	public void volumeUp(int level); // 넣고싶은 만큼 볼륨 높이기
	public void volumeDown(); // 볼륨-1
	public void volumeDown(int level);
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		} else {
			System.out.println("무음 아닙니다.");
		}
	}
	
}
