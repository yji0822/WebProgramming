package com.lec.ex01_runnable;
// �ȳ��ϼ��� 10�� ����ϴ� target
// �ȳ��ϼ���~~~~ �ݰ�~~~ or �ȳ�ݰ�~�ȳ�ݰ�~ �̰� JVM�� �� ����
public class TargetEx01 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("�ȳ��ϼ��� : " + i);
			try {
				// ���ÿ� �Ѵٴ� ���� �ȵ� ���� �۾��� 0.5�ʵ��� �����·� �־�� 
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

}
