package com.lec.ex03_phone;

public class BModel implements IAcorporation {
	private String modelName = "B��";
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB �ۼ��� ����");
	}

	@Override
	public void lte() {
		System.out.println(modelName + "�� LTE");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "�� TV������ ž��");
	}

}
