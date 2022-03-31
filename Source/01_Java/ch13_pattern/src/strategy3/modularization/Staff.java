package strategy3.modularization;

import strategy3.interfaces.GetSalary;
import strategy3.interfaces.JobMng;

public class Staff extends Person {

	private String part;
	
	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}

	@Override
	public void infoPrint() {
		System.out.println("ID: "+ getId() + "\t¿Ã∏ß: " + getName() + "\tπ›: " + part);
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

}
