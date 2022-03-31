package com.lec.ex03_phone;

public class CModel implements IAcorporation {
	private String modelName = "C모델";
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "은 DMB 송수신 불가");
	}

	@Override
	public void lte() {
		System.out.println(modelName + "은 LTE");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "은 TV리모콘 미탑재");
	}

}
