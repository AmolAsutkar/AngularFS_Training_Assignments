package factorysingleton;

class EmployeeAccount extends Account implements Profitable{

	public void withdraw(double amount) {
		System.out.println("Withdraw from Employee");
	}
	
	public void deposit(double amount) {
		System.out.println("Deposit from Employee");
	}
	
	public void addInterest(int months) {
		System.out.println("Interest added to Employee");
	}

}
