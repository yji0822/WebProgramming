package strategy3.modularization;

import strategy3.interfaces.GetSalary;
import strategy3.interfaces.JobLec;

public class Lecturer extends Person {
	private String subject;
	
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}

	@Override
	public void infoPrint() {
		System.out.println("ID: "+ getId() + "\t¿Ã∏ß: " + getName() + "\tπ›: " + subject);
	}

	// setter&getter
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
