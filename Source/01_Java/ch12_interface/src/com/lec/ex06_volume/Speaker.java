package com.lec.ex06_volume;
// Speaker s = new Speaker(45);
// s.volumDown()
public class Speaker implements IVolume {
	
	private static final byte SPEAKER_MAX_VOLUME = 50;
	private static final byte SPEAKER_MIN_VOLUME = 0;
	private int volumeLevel;

	public Speaker() {	
	}
	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		if (volumeLevel < SPEAKER_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("����Ŀ ���� 1�÷� ���� ���� " + volumeLevel);
		} else {
			System.out.println("����Ŀ ������ ���� �ִ�ġ �Դϴ�.");
		}
		
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level <= SPEAKER_MAX_VOLUME) { //level ��ŭ ���� �ø�
			volumeLevel += level;
			System.out.println("����Ŀ ������ " + level + " �÷� ���� " + volumeLevel);
		} else { // level��ŭ �� �ø� ��� ex.���纼�� 45, level 10 -> �ִ� 50������ / volume �� max(50)�� �ø���.
			// �ŭ �ø��� ���(5), ������ 50
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("����Ŀ ������ " + level + " ��ŭ �� �ø��� " 
								+ tempLevel + "��ŭ �÷� �ִ�ġ " + SPEAKER_MAX_VOLUME);
		} // if
	}

	@Override
	public void volumeDown() { //volume-1
		if(volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("����Ŀ ������ -1 �ٿ� ���� ���� " + volumeLevel);
		} else {
			System.out.println("����Ŀ ������ ���� 0�Դϴ�.");
		} //if-else
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel-level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("����Ŀ ������ " + level + " ��ŭ �ٿ� ���� " + volumeLevel);
		} else {
			int tempLevel = volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("����Ŀ ������ " + level + " ��ŭ �������� " 
			+ tempLevel + "��ŭ ���� �ּ�ġ " + SPEAKER_MIN_VOLUME);
		}
	} // volumeDown

}
