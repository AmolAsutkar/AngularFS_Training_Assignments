package com.citiustech.servicetest;

import org.junit.jupiter.api.Test;

import com.citiustech.entity.Account;
import com.citiustech.service.AccountService;

public class TestAccountService {

	@Test
	public void testOpenAccount() {
		AccountService accservice=new AccountService(); 
		Account account=new Account();
		account.setAccname("asutkar");
		account.setBalance(8000);
		account.setType("Current");
		
		accservice.openAccount(account);
	}
	
	@Test
	public void testWithdraw() {
		AccountService accservice=new AccountService();
		accservice.withdraw(4,4000);
		
		
	}
	@Test
	public void testDeposit() {
		AccountService accservice=new AccountService();
		accservice.deposit(3,2000);		
	}
	
	@Test
	public void testTransfer() {
		AccountService accservice=new AccountService();
		accservice.transfer(1,2,1000);
		
		
	}
	@Test
	public void testbalanceCheck() {
		AccountService accservice=new AccountService();
		accservice.balanceCheck(1);
		System.out.println(accservice.balanceCheck(1));
	}
	
}
