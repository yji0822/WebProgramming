package strategy3.modularization;

import strategy3.interfaces.IGet;
import strategy3.interfaces.IJob;

public abstract class Person {
	
	// 부품관련 변수
	private IJob job;
	private IGet get;
	// 공통된 변수
	private String id;
	private String name;
	
	// 생성자
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	// 메소드
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
