package strategy3.modularization;

import strategy3.interfaces.GetStudentPay;
import strategy3.interfaces.JobStudy;

public class Student extends Person {

	private String ban;
	
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudentPay());
	}
	
	@Override
	public void infoPrint() {
		System.out.println("ID: "+ getId() + "\t¿Ã∏ß: " + getName() + "\tπ›: " + ban);
	}

	// setter&getter
	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	
	

}
