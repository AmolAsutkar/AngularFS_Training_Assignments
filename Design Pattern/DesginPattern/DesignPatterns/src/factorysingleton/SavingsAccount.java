package factorysingleton;

class SavingsAccount extends Account implements Profitable{

	public void withdraw(double amount) {
		System.out.println("Withdraw from Savings");
	}
	
	public void deposit(double amount) {
		System.out.println("Deposit from Savings");
	}
	
	public void addInterest(int months) {
		System.out.println("Interest added to savings");
	}

}
