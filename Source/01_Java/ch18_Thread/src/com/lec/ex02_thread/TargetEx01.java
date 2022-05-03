package com.lec.ex02_thread;
// Thread ta = new Thread(target1, "A");
// Thread t1 = new ThreadEx01("A");
//Thread t1 = new ThreadEx01();
public class TargetEx01 extends Thread { // Thread�� ��ӹ޾� ����ϴ� ���
	
	// ������
	public TargetEx01() {}
	public TargetEx01(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println("�ȳ��ϼ��� : " + i);
			try {
				// ���ÿ� �Ѵٴ� ���� �ȵ� ���� �۾��� 0.5�ʵ��� �����·� �־�� 
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			} // try-catch
		} // for
		
	} // run
	
}
