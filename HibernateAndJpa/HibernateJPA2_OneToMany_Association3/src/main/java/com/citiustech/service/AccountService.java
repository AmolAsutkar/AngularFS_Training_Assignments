package com.citiustech.service;

import java.time.LocalDateTime;
import java.util.List;

import com.citiustech.dao.AccountTransactionDao;
import com.citiustech.dao.GenericDao;
import com.citiustech.entity.Account;
import com.citiustech.entity.TransactionDetails;

public class AccountService {

	public void openAccount(Account acc) {
		if(acc.getBalance()<5000)
			throw new RuntimeException("balance should be greater than five thousand");
		else {
			GenericDao gdao=new GenericDao();
			gdao.save(acc);
		}
			
	}
	
	// when withdraw is called there should be one entry in Transactiondetails Table
	// also the new balance should get updated in Account table
	public void withdraw(int AccountId,double amount) {
		GenericDao gdao=new GenericDao();
		Account account=gdao.findById(Account.class, AccountId);
		if(amount>account.getBalance())
			throw new RuntimeException("insufficient balance");
		else {
			account.setBalance(account.getBalance()-amount);
			gdao.save(account);
			
			TransactionDetails transactiondetails=new TransactionDetails();
			transactiondetails.setAccount(account);
			transactiondetails.setType("withdraw");
			transactiondetails.setAmount(amount);
			transactiondetails.setDateandtime(LocalDateTime.now());
			gdao.save(transactiondetails);
		}
		
	}
    
	// as of now our service class is not managing db transaction properly
	// code to begin/commit/rollback 
	public void transfer(int fromAccountId,int toAccountId,double amount) {
		
		withdraw(fromAccountId, amount);
		deposit(toAccountId, amount);
	}
    
	public void deposit(int AccountId,double amount) {
	
		GenericDao gdao=new GenericDao();
		Account account=gdao.findById(Account.class, AccountId);
		
			account.setBalance(account.getBalance()+amount);
			gdao.save(account);
			
			TransactionDetails transactiondetails=new TransactionDetails();
			transactiondetails.setAccount(account);
			transactiondetails.setType("Deposit");
			transactiondetails.setAmount(amount);
			transactiondetails.setDateandtime(LocalDateTime.now());
			gdao.save(transactiondetails);
		}
     

    public double balanceCheck(int AccountId) {
		GenericDao gdao=new GenericDao();
		Account account=gdao.findById(Account.class, AccountId);
		return account.getBalance();
	
    }
    
    // List<TransactionDetails> miniStatement(int accountId){
    //	AccountTransactionDao atd=new 	AccountTransactionDao();
    //	return atd.fetchMiniStatement(accountId);
   // }
}
