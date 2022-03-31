package strategy2.modulalization;

import strategy2.interfaces.EngineMid;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km15;

//��ӹ��� ��� : 3���� ��ǰ ���� (������) & �޼ҵ� drive(�Ϲ�), shape(�߻�), engine(�߱�...���.. �Ϲݸ޼ҵ�), km(�Ϲ�), fuel(�Ϲ�), setter
//������ ���� & �߻�Ŭ���� 

public class Accent extends Car {

	// ������
		public Accent() {
			setEngine(new EngineMid()); 
			setKm(new Km15()); 
			setFuel(new FuelGasoline()); 
		}
	
	@Override
	public void shape() {
		System.out.println("�ҳ�Ÿ ������ door, sheet, handle�� �̷���� �ֽ��ϴ�.");
	}

}
