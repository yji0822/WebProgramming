package com.lec.ex06_volume;
// TV tv = new TV(3);
// tv.volumeUp() tv.volumDown()
public class TV implements IVolume {
	
	private static final byte TV_MAX_VOLUME = 50;
	private static final byte TV_MIN_VOLUME = 0;
	private int volumeLevel;

	public TV() {	
	}
	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		if (volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV 볼륨 1올려 현재 볼륨 " + volumeLevel);
		} else {
			System.out.println("TV 볼륨이 현재 최대치 입니다.");
		}
		
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level <= TV_MAX_VOLUME) { //level 만큼 볼륨 올림
			volumeLevel += level;
			System.out.println("TV 볼륨을 " + level + " 올려 현재 " + volumeLevel);
		} else { // level만큼 못 올릴 경우 ex.현재볼륨 45, level 10 -> 최대 50까지만 / volume 은 max(50)로 올리기.
			// 몇만큼 올릴지 계산(5), 볼륨은 50
			int tempLevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 " + level + "만큼 못 올리고 " 
								+ tempLevel + "만큼 올려 최대치 " + TV_MAX_VOLUME);
		} // if
	}

	@Override
	public void volumeDown() { //volume-1
		if(volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV 볼륨을 -1 줄여 현재 볼륨 " + volumeLevel);
		} else {
			System.out.println("TV 볼륨이 현재 0입니다.");
		} //if-else
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel-level >= TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV 볼륨을 " + level + "만큼 줄여 현재 " + volumeLevel);
		} else {
			int tempLevel = volumeLevel;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV 볼륨을 " + level + "만큼 못내리고 " 
			+ tempLevel + "만큼 내려 최소치 " + TV_MIN_VOLUME);
		}
	} // volumeDown

}
