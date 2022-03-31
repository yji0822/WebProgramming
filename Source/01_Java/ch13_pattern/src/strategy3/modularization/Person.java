package strategy3.modularization;

import strategy3.interfaces.IGet;
import strategy3.interfaces.IJob;

public abstract class Person {
	
	// ��ǰ���� ����
	private IJob job;
	private IGet get;
	// ����� ����
	private String id;
	private String name;
	
	// ������
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	// �޼ҵ�
	public abstract void infoPrint();
	public void job() {
		job.job();
	}
	public void get() {
		get.get();
	}
	// getter&setter
	public IJob getJob() {
		return job;
	}
	public void setJob(IJob job) {
		this.job = job;
	}
	public IGet getGet() {
		return get;
	}
	public void setGet(IGet get) {
		this.get = get;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
