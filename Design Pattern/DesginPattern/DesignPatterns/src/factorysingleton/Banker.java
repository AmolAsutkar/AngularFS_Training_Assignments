package factorysingleton;

public class Banker {
	
	private Banker() {}

	public static Account openSavingsAccount() {
		return new SavingsAccount();
	}
	
	public static Account openCurrentAccount() {
		return new CurrentAccount();
	}
	
	public static Account openEmployeeAccount() {
		return new EmployeeAccount();
	}
}
