package home.quiz1_company;

public class HourlyEmployee extends Employee {

	private int hoursWorked; // 일한시간
	private int moneyPerHour; // 시급
	
	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}
	
	
	@Override
	public int computePay() {
		return moneyPerHour * hoursWorked; // 시급 * 일한시간
	}

	// getter&setter
	public int getHoursWorked() {
		return hoursWorked;
	}


	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}


	public int getMoneyPerHour() {
		return moneyPerHour;
	}


	public void setMoneyPerHour(int moneyPerHour) {
		this.moneyPerHour = moneyPerHour;
	}
	
	

}
