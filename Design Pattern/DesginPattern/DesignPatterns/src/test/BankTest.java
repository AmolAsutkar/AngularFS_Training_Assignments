package test;

import factorysingleton.Account;
import factorysingleton.Banker;
import factorysingleton.Profitable;

public class BankTest {

	private static void tax(Account s) {
		System.out.println("Tax paid");
	}
	
	private static void payAnnualInterest(Account[] accounts) {
		//Only add interest to Savings Account
		/*
		for (Account account : accounts) {
			if (account instanceof SavingsAccount) {
				SavingsAccount sacc = (SavingsAccount) account;
				sacc.addInterest(12);
			}
		}
		*/
		for (Account account : accounts) {
			if (account instanceof Profitable) {
				Profitable p = (Profitable) account;
				p.addInterest(12);
			}
		}
	}
	
	/*
	private static void tax(CurrentAccount s) {
		System.out.println("Tax paid");
	}
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Account[] accounts = new Account[3];
		accounts[0] = Banker.openSavingsAccount();
		accounts[1] = Banker.openCurrentAccount();
		accounts[2] = Banker.openEmployeeAccount();
		
		payAnnualInterest(accounts);
	}

}



