package com.lec.ex06_volume;

public interface IVolume { // ��ħ��
	public void volumeUp(); // ����+1
	public void volumeUp(int level); // �ְ���� ��ŭ ���� ���̱�
	public void volumeDown(); // ����-1
	public void volumeDown(int level);
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("���� ó���մϴ�.");
		} else {
			System.out.println("���� �ƴմϴ�.");
		}
	}
	
}
