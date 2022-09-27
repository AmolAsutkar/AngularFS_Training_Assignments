package factorysingleton;

class CurrentAccount extends Account{

	public void withdraw(double amount) {
		System.out.println("Withdraw from Current");
	}
	
	public void deposit(double amount) {
		System.out.println("Deposit from Current");
	}

}
