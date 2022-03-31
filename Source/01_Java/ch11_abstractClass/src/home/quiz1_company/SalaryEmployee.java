package home.quiz1_company;

public class SalaryEmployee extends Employee {
	
	private int annalSalary; // ¿¬ºÀ
	
	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}

	@Override
	public int computePay() {
		return annalSalary / 14; // ¿¬ºÀ/14°³¿ù
	}
	
	// getter&setter
	public int getAnnalSalary() {
		return annalSalary;
	}

	public void setAnnalSalary(int annalSalary) {
		this.annalSalary = annalSalary;
	}
	
	

}
