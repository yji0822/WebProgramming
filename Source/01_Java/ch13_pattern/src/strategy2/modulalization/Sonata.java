package strategy2.modulalization;

import strategy2.interfaces.EngineLow;
import strategy2.interfaces.FuelDiesel;
import strategy2.interfaces.Km20;

//��ӹ��� ��� : 3���� ��ǰ ���� (������) & �޼ҵ� drive(�Ϲ�), shape(�߻�), engine(�߱�...���.. �Ϲݸ޼ҵ�), km(�Ϲ�), fuel(�Ϲ�), setter
//������ ���� & �߻�Ŭ���� 

public class Sonata extends Car {

	// ������
		public Sonata() {
			setEngine(new EngineLow()); 
			setKm(new Km20()); 
			setFuel(new FuelDiesel()); 
		}
	
	@Override
	public void shape() {
		System.out.println("����Ʈ ������ door, sheet, handle�� �̷���� �ֽ��ϴ�.");
	}

}
