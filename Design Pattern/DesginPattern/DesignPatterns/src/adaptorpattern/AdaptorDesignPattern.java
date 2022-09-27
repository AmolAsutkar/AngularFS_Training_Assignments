package adaptorpattern;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

interface Account{
	
	void withdraw(double amount);
	void deposit(double amount);
}

class SavingsAccount implements Account{

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Savings Account withdraw was successfull");
	}

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Savings Account deposit was successfull");
	}
	
}


interface Loan{
	
	void processLoan(double loan);
}

class PersonalLoan implements Loan{

	@Override
	public void processLoan(double loan) {
		// TODO Auto-generated method stub
		System.out.println("Personal Loan processed successfully");
	}
	
}

class AccountAdaptor implements Loan{
	
	Account account;							//Aggregation    Department has-a Employee
	
	public AccountAdaptor(Account account) {
		this.account = account;
	}
	
	@Override
	public void processLoan(double amount) {
		account.withdraw(amount);
	}
}

public class AdaptorDesignPattern {
	
	public static void main(String[] args) {
		SavingsAccount sacc = new SavingsAccount();
		PersonalLoan pl = new PersonalLoan();
		
		System.out.println("Savings Account Details");
		sacc.withdraw(70000);
		sacc.deposit(2000);
		
		Loan accountAdaptor = new AccountAdaptor(sacc);
		accountAdaptor.processLoan(2000);
		accountAdaptor.processLoan(5000);
	}
}










